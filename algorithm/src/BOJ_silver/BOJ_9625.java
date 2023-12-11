package BOJ_silver;

import java.io.*;

public class BOJ_9625 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        int[] A = new int[K + 1];
        int[] B = new int[K + 1];

        A[0] = 1;
        A[1] = 0;

        B[0] = 0;
        B[1] = 1;

        for (int k = 2; k < K + 1; k++) {
            A[k] = A[k - 1] + A[k - 2];
            B[k] = B[k - 1] + B[k - 2];
        }

        System.out.println(A[K] + " " + B[K]);
    }
}
