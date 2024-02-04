package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2303 {
    static int N, max = -1, ans = 0, order = 0;
    static int[] cards;

    static void comb(int start, int depth, int sum) {
        if (depth == 3) {
            int s = sum % 10;

            if (s >= max) {
                ans = order;
                max = s;
            }
            return;
        }

        for (int i = start; i < 5; i++) {
            comb(i + 1, depth + 1, sum + cards[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());

        cards = new int[5];
        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());

            for (int m = 0; m < 5; m++) {
                cards[m] = Integer.parseInt(token.nextToken());
            }
            order = n + 1;
            comb(0, 0, 0);
        }

        System.out.println(ans);
    }
}
