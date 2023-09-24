package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_26169 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int ans = 0;

    static void search(int r, int c, int move, int apple) {
        if (move <= 3 && apple >= 2) {
            ans = 1;
            return;
        }

        if (move > 4) {
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && map[nr][nc] != -1 && !visited[nr][nc]) {
                visited[nr][nc] = true;
                if (map[nr][nc] == 1) {
                    search(nr, nc, move + 1, apple + 1);
                } else if (map[nr][nc] == 0) {
                    search(nr, nc, move + 1, apple);
                }
                visited[nr][nc] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        map = new int[5][5];
        visited = new boolean[5][5];

        for (int r = 0; r < 5; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < 5; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        token = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());

        map[r][c] = -1;
        visited[r][c] = true;
        search(r, c, 0, 0);
        System.out.println(ans);
    }
}
