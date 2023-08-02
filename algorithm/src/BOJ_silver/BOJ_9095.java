package BOJ_silver;

import java.io.*;

public class BOJ_9095 {
    static int N, ans;

    static void dp(int sum) {
        if (sum == N) {
            ans += 1;
            return;
        }

        if (sum > N)
            return;

        for (int i = 1; i < 4; i++) {
            dp(sum + i);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            ans = 0;
            dp(0);

            System.out.println(ans);
        }
    }
}
