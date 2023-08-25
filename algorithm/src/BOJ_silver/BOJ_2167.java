package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2167 {
    static int N, M, K;
    static int[][] arr;
    static int[][] sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        arr = new int[N + 1][M + 1];
        sum = new int[N + 1][M + 1];
        for (int n = 1; n < N + 1; n++) {
            token = new StringTokenizer(br.readLine());
            for (int m = 1; m < M + 1; m++) {
                arr[n][m] = Integer.parseInt(token.nextToken());
            }
        }

        for (int n = 1; n < N + 1; n++) {
            for (int m = 1; m < M + 1; m++) {
                sum[n][m] = sum[n - 1][m] + sum[n][m - 1] + arr[n][m] - sum[n - 1][m - 1];
            }
        }

        K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            token = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(token.nextToken());
            int j = Integer.parseInt(token.nextToken());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            int ans = sum[x][y] + sum[i - 1][j - 1] - sum[i - 1][y] - sum[x][j - 1];
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
