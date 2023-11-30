package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_11728 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        token = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            A[n] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
            B[m] = Integer.parseInt(token.nextToken());
        }

        int a = 0;
        int b = 0;
        while (a != N && b != M) {

            if (A[a] < B[b]) {
                sb.append(A[a++]).append(" ");
            } else {
                sb.append(B[b++]).append(" ");
            }
        }

        if (a == N) {
            for (int i = b; i < M; i++) {
                sb.append(B[i]).append(" ");
            }
        } else if (b == M) {
            for (int i = a; i < N; i++) {
                sb.append(A[i]).append(" ");
            }
        }

        System.out.println(sb);
    }
}
