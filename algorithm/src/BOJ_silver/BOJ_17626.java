package BOJ_silver;

import java.io.*;

public class BOJ_17626 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] ans = new int[N + 1];

        for (int n = 1; n <= N; n++) {
            ans[n] = 100;
        }

        ans[0] = 0;
        for (int n = 1; n <= N; n++) {
            for (int i = 1; i <= N; i++) {
                int num = i * i;
                if (num > n)
                    break;
                ans[n] = Math.min(ans[n - num] + 1, ans[n]);
            }
        }

        System.out.println(ans[N]);
    }
}
