package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        token = new StringTokenizer(br.readLine());

        for (int n = 0; n < N; n++) {
            nums[n] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(nums);
        int min = 0;
        int max = 0;

        int head = 0;
        int tail = N - 1;

        int flag = Integer.MAX_VALUE;
        while (head < tail) {
            int sum = nums[head] + nums[tail];

            if (flag > Math.abs(sum)) {
                flag = Math.abs(sum);
                min = nums[head];
                max = nums[tail];
            }

            if (sum > 0) {
                tail--;
            } else if (sum < 0) {
                head++;
            } else if (sum == 0) {
                break;
            }

        }

        System.out.println(min + " " + max);
    }
}
