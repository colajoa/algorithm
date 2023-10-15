package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_3273 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        token = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            nums[n] = Integer.parseInt(token.nextToken());
        }

        int X = Integer.parseInt(br.readLine());
        Arrays.sort(nums);

        int head = 0;
        int tail = N - 1;

        int ans = 0;
        while (head < tail) {

            int sum = nums[head] + nums[tail];

            if (sum == X) {
                head++;
                tail--;
                ans++;
            } else if (sum > X) {
                tail--;
            } else if (sum < X) {
                head++;
            }
        }

        System.out.println(ans);
    }
}
