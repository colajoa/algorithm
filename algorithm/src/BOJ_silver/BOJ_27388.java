package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_27388 {
    static int R, C, ans, dot;
    static char[][] map;
    static boolean[][] visited;
    static boolean flag;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]
                    && (map[nr][nc] == '.' || map[nr][nc] == ' ')) {
                if (map[nr][nc] == '.') {
                    flag = true;
                    dot -= 1;
                }
                dfs(nr, nc);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
                if (map[r][c] == '.') {
                    dot += 1;
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                flag = false;
                if (map[r][c] - 'A' >= 0 && map[r][c] - 'A' <= 22) {
                    dfs(r, c);
                    if (flag) {
                        ans += 1;
                    }
                }
            }
        }

        System.out.println(ans + " " + dot);
    }
}
