package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_20529 {
    static int N, min;

    static String[] MBTI;
    static String[] students = new String[3];

    static void comb(int start, int depth) {
        if (depth == 3) {
            int sum = 0;
            for (int i = 0; i < 4; i++) {
                if (students[0].charAt(i) != students[1].charAt(i) || students[0].charAt(i) != students[2].charAt(i)
                        || students[1].charAt(i) != students[2].charAt(i)) {
                    sum += 2;
                }
            }
            min = Math.min(min, sum);
            return;
        }

        for (int i = start; i < N; i++) {
            students[depth] = MBTI[i];
            comb(i + 1, depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            token = new StringTokenizer(br.readLine());
            if (N > 32) {
                sb.append("0\n");
                continue;
            }

            MBTI = new String[N];
            for (int n = 0; n < N; n++) {
                String mbti = token.nextToken();
                MBTI[n] = mbti;
            }

            min = Integer.MAX_VALUE;

            comb(0, 0);
            sb.append(min).append("\n");

        }
        System.out.println(sb);
    }
}
