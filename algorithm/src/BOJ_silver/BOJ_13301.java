package BOJ_silver;

import java.io.*;

public class BOJ_13301 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] side = new long[N + 1];
        long[] square = new long[N + 1];

        side[1] = 1;
        square[1] = 4;

        for (int n = 2; n < N + 1; n++) {
            side[n] = side[n - 1] + side[n - 2];
            square[n] = square[n - 1] + (side[n] * 2);
        }
        System.out.println(square[N]);
    }
}
