package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_1932 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        int N = Integer.parseInt(br.readLine());

        int[][] nums = new int[N][N];
        int[][] ans = new int[N][N];

        int inc = 1;
        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());
            for (int i = 0; i < inc; i++) {
                nums[n][i] = Integer.parseInt(token.nextToken());
            }
            inc++;
        }

        ans[0][0] = nums[0][0];

        if (N == 1) {
            System.out.println(nums[0][0]);
        } else {
            ans[1][0] = ans[0][0] + nums[1][0];
            ans[1][1] = ans[0][0] + nums[1][1];
            int max = -1;
            for (int n = 2; n < N; n++) {
                ans[n][0] = ans[n - 1][0] + nums[n][0];

                for (int k = 1; k < n; k++) {
                    ans[n][k] = Math.max(ans[n - 1][k - 1] + nums[n][k], ans[n - 1][k] + nums[n][k]);
                }

                ans[n][n] = ans[n - 1][n - 1] + nums[n][n];
            }

            for (int n = 0; n < N; n++) {
                max = Math.max(max, ans[N - 1][n]);
            }
            System.out.println(max);
        }
    }
}
