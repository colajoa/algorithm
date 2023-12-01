package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_14546 {
    static int L, W, A, B, C, D;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static boolean flag;

    static boolean dfs(int r, int c) {
        visited[r][c] = true;
        if (r == D && c == C) {
            return true;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < W && nc >= 0 && nc < L && !visited[nr][nc] && map[r][c] == map[nr][nc]) {
                if (dfs(nr, nc)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            token = new StringTokenizer(br.readLine());

            L = Integer.parseInt(token.nextToken());
            W = Integer.parseInt(token.nextToken());
            A = Integer.parseInt(token.nextToken()) - 1;
            B = W - Integer.parseInt(token.nextToken());
            C = Integer.parseInt(token.nextToken()) - 1;
            D = W - Integer.parseInt(token.nextToken());

            map = new char[W][L];
            visited = new boolean[W][L];

            for (int r = 0; r < W; r++) {
                String str = br.readLine();
                for (int c = 0; c < L; c++) {
                    map[r][c] = str.charAt(c);
                }
            }

            if (dfs(B, A)) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }
}
