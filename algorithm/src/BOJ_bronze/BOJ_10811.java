package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_10811 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[] basket = new int[N + 1];

        for (int n = 1; n < N + 1; n++) {
            basket[n] = n;
        }

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());

            int len = start + end;
            int cnt = (end - start + 1) / 2;

            for (int i = start; i < start + cnt; i++) {
                int from = i;
                int to = len - i;
                int swap = basket[from];

                basket[from] = basket[to];
                basket[to] = swap;
            }
        }

        for (int n = 1; n < N + 1; n++) {
            sb.append(basket[n]).append(" ");
        }
        System.out.println(sb);
    }
}