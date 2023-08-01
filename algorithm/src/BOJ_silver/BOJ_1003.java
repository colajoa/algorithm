package BOJ_silver;

import java.io.*;

public class BOJ_1003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] nums = new int[41][2];

        for (int n = 0; n < 41; n++) {
            if (n == 0) {
                nums[n][0] = 1;
                nums[n][1] = 0;
            } else if (n == 1) {
                nums[n][0] = 0;
                nums[n][1] = 1;
            } else {
                nums[n][0] = nums[n - 1][0] + nums[n - 2][0];
                nums[n][1] = nums[n - 1][1] + nums[n - 2][1];
            }
        }
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(nums[N][0] + " " + nums[N][1]);
        }
    }
}
