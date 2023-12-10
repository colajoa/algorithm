package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_16390 {
    static int M, N;
    static char[][] map;
    static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

    static void dfs(int r, int c) {
        map[r][c] = '.';

        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] == '#') {
                dfs(nr, nc);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());

        map = new char[M][N];

        for (int m = 0; m < M; m++) {
            String str = br.readLine();
            for (int n = 0; n < N; n++) {
                map[m][n] = str.charAt(n);
            }
        }

        int cnt = 0;

        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                if (map[m][n] == '#') {
                    dfs(m, n);
                    cnt += 1;
                }
            }
        }

        System.out.println(cnt);
    }
}
