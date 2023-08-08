package BOJ_silver;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11047 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        int[] coins = new int[N];
        int cnt = 0;

        for (int n = 0; n < N; n++) {
            coins[n] = Integer.parseInt(br.readLine());
        }

        while (K != 0) {
            if (K / coins[--N] > 0) {
                cnt += K / coins[N];
                K %= coins[N];
            }
        }

        System.out.println(cnt);
    }
}
