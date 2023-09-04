package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_15657 {
    static int N, M;
    static int[] nums;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();

    static void sequence(int depth) {
        if (depth == M) {
            for (int m = 0; m < M; m++) {
                sb.append(ans[m]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            ans[depth] = nums[i];
            if (ans[depth - 1] <= ans[depth]) {
                sequence(depth + 1);
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

        for (int n = 0; n < N; n++) {
            ans[0] = nums[n];
            sequence(1);
        }

        System.out.println(sb);
    }
}
