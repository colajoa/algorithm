package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_6031 {
    static int W, H, max = 0, cnt;
    static char[][] map;

    static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

    static void dfs(int r, int c) {
        cnt += 1;
        map[r][c] = '*';

        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == '.') {
                dfs(nr, nc);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        W = Integer.parseInt(token.nextToken());
        H = Integer.parseInt(token.nextToken());

        map = new char[H][W];
        for (int r = 0; r < H; r++) {
            String str = br.readLine();
            for (int c = 0; c < W; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (map[r][c] == '.') {
                    cnt = 0;
                    dfs(r, c);

                    max = cnt > max ? cnt : max;
                }
            }
        }

        System.out.println(max);
    }
}
