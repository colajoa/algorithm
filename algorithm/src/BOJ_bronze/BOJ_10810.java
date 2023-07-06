package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_10810 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[] basket = new int[N + 1];

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(token.nextToken());
            int end = Integer.parseInt(token.nextToken());
            int ball = Integer.parseInt(token.nextToken());

            for (int idx = start; idx <= end; idx++) {
                basket[idx] = ball;
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(basket[i] + " ");
        }
    }
}
