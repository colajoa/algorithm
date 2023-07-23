package BOJ_silver;

import java.io.*;

public class BOJ_2485 {
    static int GCD(int a, int b) {
        if (a % b == 0)
            return b;
        return GCD(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] diff = new int[N - 1];
        int start = Integer.parseInt(br.readLine());
        int s = start;
        int end = 0;
        for (int n = 0; n < N - 1; n++) {
            int num = Integer.parseInt(br.readLine());
            diff[n] = num - s;
            end = num;
            s = num;
        }
        int gcd = GCD(diff[0], diff[1]);
        for (int i = 2; i < N - 1; i++) {
            gcd = GCD(diff[i], gcd);
        }

        System.out.println((((end - start + 1) - 2) / gcd) - (N - 2));
    }
}
