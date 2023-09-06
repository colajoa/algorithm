package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_15663 {
    static int N, M;

    static int[] nums;
    static int[] ans;
    static boolean[] selected;
    static StringBuilder sb = new StringBuilder();

    static void sequence(int depth) {
        if (depth == M) {
            for (int m = 0; m < M; m++) {
                sb.append(ans[m]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int flag = 0;

        for (int n = 0; n < N; n++) {

            if (!selected[n] && flag != nums[n]) {
                flag = nums[n];
                ans[depth] = nums[n];
                selected[n] = true;
                sequence(depth + 1);
                selected[n] = false;
            }

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());

        nums = new int[N];
        ans = new int[M];
        selected = new boolean[N];

        for (int n = 0; n < N; n++) {
            nums[n] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(nums);

        sequence(0);

        System.out.println(sb);
    }
}
