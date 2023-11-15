package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_6080 {
    static int R, C;
    static int[][] map;
    static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

    static void dfs(int r, int c) {
        map[r][c] = 0;

        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != 0) {
                dfs(nr, nc);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        map = new int[R][C];
        for (int r = 0; r < R; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        int cnt = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] != 0) {
                    dfs(r, c);
                    cnt += 1;
                }
            }
        }

        System.out.println(cnt);
    }
}
