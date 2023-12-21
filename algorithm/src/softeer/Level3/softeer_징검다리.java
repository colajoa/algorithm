package softeer.Level3;

import java.io.*;
import java.util.*;

public class softeer_징검다리 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        int[] dp = new int[N];
        token = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            nums[n] = Integer.parseInt(token.nextToken());
            dp[n] = 1;
        }

        for (int n = 0; n < N; n++) {
            System.out.println("N : " + n);
            for (int i = 0; i < n; i++) {
                System.out
                        .print(" i : " + i + " " + nums[i] + " < " + nums[n] + " " + (nums[i] < nums[n]) + " dp[n] : "
                                + dp[n]
                                + " dp[i] + 1 : " + (dp[i] + 1));
                if (nums[i] < nums[n]) {
                    dp[n] = Math.max(dp[n], dp[i] + 1);
                }
                System.out.println(" dp[n] : " + dp[n]);
            }
        }

        Arrays.sort(dp);

        System.out.println(dp[N - 1]);
    }
}
