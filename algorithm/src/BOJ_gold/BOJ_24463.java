package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_24463 {
    static int N, M;
    static int[][] p = new int[2][2];
    static char[][] map;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static void dfs(int r, int c) {
        if (r == p[1][0] && c == p[1][1]) {
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == '@') {
                map[nr][nc] = '.';
                dfs(nr, nc);
                map[nr][nc] = '@';
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new char[N][M];

        int s = 0;
        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = str.charAt(c);
                if (map[r][c] == '.') {
                    if (r == 0 || r == N - 1 || c == 0 || c == M - 1) {
                        p[s][0] = r;
                        p[s][1] = c;
                        s++;
                    }
                    map[r][c] = '@';
                }
            }
        }

        dfs(p[0][0], p[0][1]);

        map[p[0][0]][p[0][1]] = '.';
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                sb.append(map[r][c]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
