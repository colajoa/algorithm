package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_15664 {
    static int N, M;
    static int[] ans, nums;
    static boolean[] selected;
    static boolean[] start;
    static StringBuilder sb = new StringBuilder();

    static void comb(int depth) {
        if (depth == M) {
            for (int m = 0; m < M; m++) {
                sb.append(ans[m]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int flag = 0;
        for (int n = 1; n < N; n++) {
            ans[depth] = nums[n];
            if (!selected[n] && flag != nums[n] && ans[depth - 1] <= ans[depth]) {
                flag = nums[n];
                selected[n] = true;
                comb(depth + 1);
                selected[n] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        nums = new int[N];
        ans = new int[N];
        selected = new boolean[N];
        start = new boolean[10001];
        token = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            nums[n] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(nums);

        for (int n = 0; n < N; n++) {
            if (!start[nums[n]]) {
                start[nums[n]] = true;
                selected[n] = true;
                ans[0] = nums[n];
                comb(1);
            }
        }

        System.out.println(sb);
    }
}
