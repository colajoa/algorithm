package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_1026 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer token = new StringTokenizer(br.readLine());

        int[] A = new int[N];

        for (int n = 0; n < N; n++) {
            A[n] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine());
        int[] B = new int[N];

        for (int n = 0; n < N; n++) {
            B[n] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for (int n = 0; n < N; n++) {
            sum += A[n] * B[(N - 1) - n];
        }

        System.out.println(sum);
    }
}
