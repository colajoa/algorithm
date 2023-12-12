package BOJ_silver;

import java.io.*;

public class BOJ_14916 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] coins = new int[N + 1];

        if (N >= 1) {
            coins[1] = -1;
        }
        if (N >= 2) {
            coins[2] = 1;
        }
        if (N >= 3) {
            coins[3] = -1;
        }
        if (N >= 5) {
            coins[5] = 1;
        }

        for (int n = 4; n < N + 1; n++) {
            if (coins[n] != 0)
                continue;

            if (n % 5 == 0) {
                coins[n] = coins[n - 5] + 1;
            } else if (n % 2 == 0) {
                coins[n] = coins[n - 2] + 1;
            } else if (n % 2 == 1) {
                coins[n] = coins[n - 2] + 1;
            }
        }

        System.out.println(coins[N]);
    }
}
