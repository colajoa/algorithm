package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_9613 {
    static int N;
    static long ans;
    static int[] nums = new int[100];
    static int[] selected = new int[2];

    static int GCD(int A, int B) {
        if (B == 0)
            return A;
        return GCD(B, A % B);
    }

    static void comb(int depth, int start) {
        if (depth == 2) {
            ans += GCD(selected[0], selected[1]);
            return;
        }

        for (int i = start; i < N; i++) {
            selected[depth] = nums[i];
            comb(depth + 1, i + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            token = new StringTokenizer(br.readLine());

            N = Integer.parseInt(token.nextToken());

            for (int n = 0; n < N; n++) {
                nums[n] = Integer.parseInt(token.nextToken());
            }

            ans = 0;

            comb(0, 0);

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
