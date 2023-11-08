package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2309 {
    static int sum = 0;
    static boolean flag = false;
    static int[] nums = new int[9];
    static int[] selected = new int[2];

    static void comb(int depth, int start, int sum) {
        if (depth == 2) {
            if (sum == 100) {
                flag = true;
                for (int n = 0; n < 9; n++) {
                    if (nums[n] != selected[0] && nums[n] != selected[1]) {
                        System.out.println(nums[n]);
                    }
                }
            }
            return;
        }

        for (int i = start; i < 9 && !flag; i++) {
            selected[depth] = nums[i];
            comb(depth + 1, start + 1, sum - nums[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int n = 0; n < 9; n++) {
            nums[n] = Integer.parseInt(br.readLine());
            sum += nums[n];
        }

        Arrays.sort(nums);

        comb(0, 0, sum);
    }
}
