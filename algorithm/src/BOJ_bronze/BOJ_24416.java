package BOJ_bronze;

import java.io.*;

public class BOJ_24416 {
    static int cnt;

    static int fib(int n) {
        if (n == 1 || n == 2) {
            cnt += 1;
            return 1;
        } else
            return fib(n - 1) + fib(n - 2);
    }

    static int fibonacci(int n) {
        int[] f = new int[n + 1];
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++) {
            cnt += 1;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        cnt = 0;
        fib(N);
        System.out.print(cnt + " ");

        cnt = 0;
        fibonacci(N);
        System.out.print(cnt);
    }
}