package BOJ_silver;

import java.io.*;

public class BOJ_2579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] stairs = new int[301];
        int[] dp = new int[301];
        for (int n = 1; n < N + 1; n++) {
            stairs[n] = Integer.parseInt(br.readLine());
        }

        dp[1] = stairs[1];
        dp[2] = stairs[2] + stairs[1];
        dp[3] = Math.max(stairs[1] + stairs[3], stairs[3] + stairs[2]);

        for (int n = 4; n < N + 1; n++) {
            dp[n] = Math.max(dp[n - 2] + stairs[n], dp[n - 3] + stairs[n - 1] + stairs[n]);
        }

        System.out.println(dp[N]);
    }
}
