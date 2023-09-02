package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_1189 {
    static int R, C, K, ans = 0;

    static char[][] map;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static void dfs(int r, int c, int cnt) {
        if (r == 0 && c == C - 1 && cnt == K) {
            ans += 1;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] != 'T' && map[nr][nc] == '.') {
                map[nr][nc] = 'v';
                dfs(nr, nc, cnt + 1);
                map[nr][nc] = '.';
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        map = new char[R][C];

        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
            }
        }
        map[R - 1][0] = 'v';
        dfs(R - 1, 0, 1);
        System.out.println(ans);
    }
}
