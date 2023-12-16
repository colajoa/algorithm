package BOJ_silver;

import java.io.*;

public class BOJ_10844 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] num = new int[N + 1][10];

        num[1][0] = 0;
        num[1][1] = 1;
        num[1][2] = 1;
        num[1][3] = 1;
        num[1][4] = 1;
        num[1][5] = 1;
        num[1][6] = 1;
        num[1][7] = 1;
        num[1][8] = 1;
        num[1][9] = 1;

        int div = 1_000_000_000;

        for (int n = 2; n < N + 1; n++) {
            num[n][0] = num[n - 1][1];
            num[n][1] = (num[n - 1][0] + num[n - 1][2]) % div;
            num[n][2] = (num[n - 1][1] + num[n - 1][3]) % div;
            num[n][3] = (num[n - 1][2] + num[n - 1][4]) % div;
            num[n][4] = (num[n - 1][3] + num[n - 1][5]) % div;
            num[n][5] = (num[n - 1][4] + num[n - 1][6]) % div;
            num[n][6] = (num[n - 1][5] + num[n - 1][7]) % div;
            num[n][7] = (num[n - 1][6] + num[n - 1][8]) % div;
            num[n][8] = (num[n - 1][7] + num[n - 1][9]) % div;
            num[n][9] = num[n - 1][8];
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += num[N][i];
            sum %= div;
        }
        System.out.println(sum);
    }
}
