package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_1987 {
    static int R, C, ans = 1;
    static int[][] map;
    static boolean[] visited = new boolean[26];
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static void dfs(int r, int c, int cnt) {

        if (visited[map[r][c]]) {
            ans = Math.max(ans, cnt);
            return;
        }

        visited[map[r][c]] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {

                dfs(nr, nc, cnt + 1);
            }
        }
        visited[map[r][c]] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        map = new int[R][C];

        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c) - 'A';
            }
        }

        dfs(0, 0, 0);

        System.out.println(ans);

    }
}
