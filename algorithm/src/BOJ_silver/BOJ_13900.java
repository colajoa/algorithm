package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_13900 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        int N = Integer.parseInt(br.readLine());
        long[] nums = new long[N];

        token = new StringTokenizer(br.readLine());

        for (int n = 0; n < N; n++) {
            nums[n] = Long.parseLong(token.nextToken());
        }

        long ans = 0;
        long acc = 0;
        for (int n = N - 2; n > -1; n--) {
            acc += nums[n + 1];
            ans += acc * nums[n];
        }

        System.out.println(ans);
    }
}
