package BOJ_silver;

import java.io.*;

public class BOJ_4134 {
    static boolean isPrime(long N) {
        if (N < 2)
            return false;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            long N = Long.parseLong(br.readLine());

            while (true) {
                if (isPrime(N)) {
                    System.out.println(N);
                    break;
                }
                N += 1;
            }
        }
    }
}