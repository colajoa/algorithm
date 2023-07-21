package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_25305 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int k = Integer.parseInt(token.nextToken());

        int[] score = new int[N];
        token = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(token.nextToken());
        }

        Arrays.sort(score);

        System.out.println(score[N - k]);
    }
}
