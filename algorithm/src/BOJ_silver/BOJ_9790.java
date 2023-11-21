package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_9790 {
    static int R, C, sr, sc, cnt;
    static char[][] map;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static void dfs(int r, int c) {
        map[r][c] = '#';
        cnt += 1;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == '.') {
                dfs(nr, nc);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while ((C = Integer.parseInt(token.nextToken())) != 0 && (R = Integer.parseInt(token.nextToken())) != 0) {
            map = new char[R][C];
            cnt = 0;
            for (int r = 0; r < R; r++) {
                String str = br.readLine();
                for (int c = 0; c < C; c++) {
                    map[r][c] = str.charAt(c);

                    if (map[r][c] == 'A') {
                        sr = r;
                        sc = c;
                    }
                }
            }

            dfs(sr, sc);
            sb.append(cnt).append("\n");
            token = new StringTokenizer(br.readLine());
        }

        System.out.println(sb);
    }
}
