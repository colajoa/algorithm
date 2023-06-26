package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_16938 {
    static int N, L, R, X, ans = 0;
    static int[] nums;
    static boolean[] selected;

    static void subSet(int depth, int cnt, int sum, int min, int max) {
        if (depth == N) {

            if (cnt < 2) {
                return;
            }

            if (max - min >= X && sum <= R && sum >= L) {
                ans += 1;
            }
            return;
        }
        subSet(depth + 1, cnt, sum, min, max);
        subSet(depth + 1, cnt + 1, sum + nums[depth], min > nums[depth] ? nums[depth] : min,
                max < nums[depth] ? nums[depth] : max);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        L = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());
        X = Integer.parseInt(token.nextToken());

        nums = new int[N];
        selected = new boolean[N];

        token = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(token.nextToken());
        }

        subSet(0, 0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        System.out.println(ans);
    }
}
