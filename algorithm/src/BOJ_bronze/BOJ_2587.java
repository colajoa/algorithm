package BOJ_bronze;

import java.io.*;

public class BOJ_2587 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int[] nums = new int[5];

        for (int i = 0; i < 5; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }

        for (int i = 4; i > 0; i--) {
            int max = nums[i];
            for (int j = 0; j < i; j++) {
                if (nums[j] > max) {
                    nums[i] = nums[j];
                    nums[j] = max;
                    max = nums[i];
                }
            }
        }

        System.out.println(sum / 5);
        System.out.println(nums[2]);
    }
}