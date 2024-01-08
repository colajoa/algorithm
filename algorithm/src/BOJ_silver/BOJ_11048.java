package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_11048 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[][] map = new int[N][M];
        int[][] dp = new int[N][M];
        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        dp[0][0] = map[0][0];

        for (int r = 1; r < N; r++) {
            dp[r][0] = dp[r - 1][0] + map[r][0];
        }

        for (int c = 1; c < M; c++) {
            dp[0][c] = dp[0][c - 1] + map[0][c];
        }

        for (int r = 1; r < N; r++) {
            for (int c = 1; c < M; c++) {
                dp[r][c] = Math.max(dp[r - 1][c] + map[r][c], dp[r][c - 1] + map[r][c]);
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}
