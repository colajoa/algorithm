package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_26999 {
    static int R, C, max = 0, cnt;
    static char[][] map;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static void dfs(int r, int c) {
        cnt += 1;
        map[r][c] = '.';

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '*') {
                dfs(nr, nc);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        C = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());

        map = new char[R][C];
        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == '*') {
                    cnt = 0;
                    dfs(r, c);
                    max = cnt > max ? cnt : max;
                }
            }
        }
        System.out.println(max);
    }
}
