package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2343 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[] lec = new int[N];

        int start = 0;
        int end = 0;

        token = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            lec[n] = Integer.parseInt(token.nextToken());
            start = Math.max(lec[n], start);
            end += lec[n];
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            int sum = 0;
            int cnt = 0;

            for (int n = 0; n < N; n++) {
                if (sum + lec[n] > mid) {
                    cnt += 1;
                    sum = 0;
                }
                sum += lec[n];
            }

            if (sum != 0) {
                cnt += 1;
            }
            if (cnt > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}
