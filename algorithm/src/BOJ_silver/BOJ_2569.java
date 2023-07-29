package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2569 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());
        long max = 0;
        long sum = 0;
        int[] temps = new int[N];

        token = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            temps[n] = Integer.parseInt(token.nextToken());
        }

        for (int k = 0; k < K; k++) {

            max += temps[k];
            sum = max;
        }

        for (int k = 0; k < N - K; k++) {
            sum = sum - temps[k] + temps[K + k];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
