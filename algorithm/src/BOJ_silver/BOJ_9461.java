package BOJ_silver;

import java.io.*;

public class BOJ_9461 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        long[] nums = new long[101];

        nums[1] = 1;
        nums[2] = 1;

        for (int n = 3; n <= 100; n++) {
            nums[n] = nums[n - 3] + nums[n - 2];
        }
        for (int t = 0; t < T; t++) {
            sb.append(nums[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
}
