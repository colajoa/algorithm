package BOJ_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11726_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] nums = new long[1001];

        nums[1] = 1;
        nums[2] = 2;

        for (int i = 3; i < 1001; i++) {
            nums[i] = (nums[i - 2] + nums[i - 1]) % 10007;
        }
        System.out.println(nums[N] % 10007);
    }
}