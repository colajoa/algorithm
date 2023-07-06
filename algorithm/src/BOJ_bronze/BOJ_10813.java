package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_10813 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[] basket = new int[N + 1];

        for (int n = 1; n <= N; n++) {
            basket[n] = n;
        }

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());

            int swap = basket[from];
            basket[from] = basket[to];
            basket[to] = swap;
        }

        for (int n = 1; n <= N; n++) {
            System.out.print(basket[n] + " ");
        }
    }
}
