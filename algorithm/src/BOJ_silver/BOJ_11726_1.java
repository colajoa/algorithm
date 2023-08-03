package BOJ_silver;

import java.io.*;

public class BOJ_11726_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] comb = new long[1001][1001];
        long ans = 0;

        for (int n = 1; n < 1001; n++) {
            comb[n][0] = 1;
            comb[n][n] = 1;
        }

        for (int n = 2; n < 1001; n++) {
            for (int r = 1; r < 1001; r++) {
                comb[n][r] = (comb[n - 1][r - 1] + comb[n - 1][r]) % 10007;
            }
        }

        int N = Integer.parseInt(br.readLine());
        int min = (int) Math.round((double) N / 2);

        int cnt = 0;
        for (int n = N; n >= min; n--) {
            ans += comb[n][cnt++];
        }

        System.out.println(ans % 10007);
    }
}