package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_2435 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        int[] temp = new int[N];

        token = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(token.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int[] sum = new int[(N - K) + 1];
        for (int i = 0; i < (N - K) + 1; i++) {
            for (int j = i; j < i + K; j++) {
                sum[i] += temp[j];
            }
            max = Math.max(max, sum[i]);
        }

        System.out.println(max);
    }
}
