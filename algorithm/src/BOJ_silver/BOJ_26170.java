package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_26170 {
    static int r, c, min = Integer.MAX_VALUE;
    static int[][] map = new int[5][5];
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static void dfs(int r, int c, int apple, int move) {
        if (apple < 3 && min < move) {
            return;
        }

        if (apple == 3) {
            min = min > move ? move : min;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && map[nr][nc] != -1) {
                int org = map[nr][nc];
                if (map[nr][nc] == 0) {
                    map[nr][nc] = -1;
                    dfs(nr, nc, apple, move + 1);
                } else if (map[nr][nc] == 1) {
                    map[nr][nc] = -1;
                    dfs(nr, nc, apple + 1, move + 1);
                }

                map[nr][nc] = org;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        for (int r = 0; r < 5; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < 5; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        token = new StringTokenizer(br.readLine());

        r = Integer.parseInt(token.nextToken());
        c = Integer.parseInt(token.nextToken());

        map[r][c] = -1;
        dfs(r, c, 0, 0);

        min = min == Integer.MAX_VALUE ? -1 : min;
        System.out.println(min);
    }
}
