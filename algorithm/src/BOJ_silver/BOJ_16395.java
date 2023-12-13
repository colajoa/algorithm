package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_16395 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        long[][] nums = new long[N + 1][N + 1];

        nums[1][1] = 1;

        if (N >= 2) {
            nums[2][1] = 1;
            nums[2][2] = 1;
        }

        for (int n = 3; n < N + 1; n++) {
            nums[n][1] = 1;
            nums[n][n] = 1;
            for (int k = 2; k < n; k++) {
                nums[n][k] = nums[n - 1][k - 1] + nums[n - 1][k];
            }
        }

        System.out.println(nums[N][K]);
    }
}
