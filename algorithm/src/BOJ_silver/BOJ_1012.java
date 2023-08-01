package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_1012 {
    static int[][] ground;
    static int ans, N, M;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static void search(int r, int c) {
        ground[r][c] = -1;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < N && nc >= 0 && nc < M && ground[nr][nc] == 1) {
                search(nr, nc);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            token = new StringTokenizer(br.readLine());

            M = Integer.parseInt(token.nextToken());
            N = Integer.parseInt(token.nextToken());
            int K = Integer.parseInt(token.nextToken());

            ground = new int[N][M];

            for (int k = 0; k < K; k++) {
                token = new StringTokenizer(br.readLine());

                int c = Integer.parseInt(token.nextToken());
                int r = Integer.parseInt(token.nextToken());

                ground[r][c] = 1;
            }

            ans = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (ground[r][c] == 1) {
                        search(r, c);
                        ans += 1;
                    }
                }
            }

            System.out.println(ans);

        }
    }
}
