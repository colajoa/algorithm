package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_15666 {
    static int N, M;
    static int[] nums, ans;
    static boolean[] selected;
    static StringBuilder sb = new StringBuilder();

    static void sequence(int depth, int num) {
        if (depth == M) {
            for (int m = 0; m < M; m++) {
                sb.append(ans[m]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int flag = 0;
        for (int n = 0; n < N; n++) {
            if (flag != nums[n] && num <= nums[n]) {
                flag = nums[n];
                ans[depth] = nums[n];
                sequence(depth + 1, nums[n]);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        nums = new int[N];
        ans = new int[M];

        token = new StringTokenizer(br.readLine());

        for (int n = 0; n < N; n++) {
            nums[n] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(nums);
        sequence(0, 0);
        System.out.println(sb);
    }
}
