package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[] nums = new int[N + 1];
        int[] sum = new int[N + 1];
        token = new StringTokenizer(br.readLine());
        for (int n = 1; n < N + 1; n++) {
            nums[n] = Integer.parseInt(token.nextToken());
        }

        sum[1] = nums[1];

        for (int n = 2; n < N + 1; n++) {
            sum[n] = sum[n - 1] + nums[n];
        }

        int cnt = 0;
        for (int n = 0; n < N; n++) {
            for (int m = n; m < N + 1; m++) {
                if (sum[m] - sum[n] == M) {
                    cnt += 1;
                }
            }
        }

        System.out.println(cnt);
    }
}
