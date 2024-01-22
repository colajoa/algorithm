package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_6211 {
    static int C, B, max = -1;
    static int[] nums;

    static void comb(int depth, int sum) {
        if (sum > C) {
            return;
        }

        if (depth == B) {
            max = Math.max(max, sum);
            return;
        }

        comb(depth + 1, sum + nums[depth]);
        comb(depth + 1, sum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        C = Integer.parseInt(token.nextToken());
        B = Integer.parseInt(token.nextToken());

        nums = new int[B];
        token = new StringTokenizer(br.readLine());
        for (int b = 0; b < B; b++) {
            nums[b] = Integer.parseInt(token.nextToken());
        }

        comb(0, 0);
        System.out.println(max);
    }
}
