package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_1182 {
    static int N, S, ans = 0;
    static int[] nums;

    static void back(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                ans += 1;
            }
            return;
        }

        back(depth + 1, sum + nums[depth]);
        back(depth + 1, sum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        S = Integer.parseInt(token.nextToken());

        nums = new int[N];
        token = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            nums[n] = Integer.parseInt(token.nextToken());
        }

        back(0, 0);

        if (S == 0) {
            ans -= 1;
        }
        System.out.println(ans);
    }
}
