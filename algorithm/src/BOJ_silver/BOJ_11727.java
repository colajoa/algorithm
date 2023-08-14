package BOJ_silver;

import java.io.*;

public class BOJ_11727 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] num = new long[1001];

        num[1] = 1;
        num[2] = 3;

        for (int n = 3; n <= N; n++) {
            num[n] = ((num[n - 1] % 10007) + (num[n - 2] * 2 % 10007)) % 10007;
        }

        System.out.println(num[N]);
    }
}
