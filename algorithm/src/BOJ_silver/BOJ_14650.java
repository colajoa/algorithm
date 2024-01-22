package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_14650 {
    static int N, ans = 0;

    static void back(int depth, int sum) {
        if (depth == N) {
            if (sum % 3 == 0) {
                ans += 1;
            }
            return;
        }

        for (int i = 0; i < 3; i++) {
            back(depth + 1, sum + i);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i < 3; i++) {
            back(1, i);
        }

        System.out.println(ans);
    }
}
