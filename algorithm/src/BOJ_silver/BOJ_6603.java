package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_6603 {
    static int K;
    static int[] nums;
    static int[] selected = new int[6];
    static StringBuilder sb = new StringBuilder();

    static void comb(int depth, int start) {
        if (depth == 6) {

            for (int n = 0; n < 6; n++) {
                sb.append(selected[n]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (int i = start; i < K; i++) {
            selected[depth] = nums[i];
            comb(depth + 1, i + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        while ((K = Integer.parseInt(token.nextToken())) != 0) {
            nums = new int[K];
            for (int k = 0; k < K; k++) {
                nums[k] = Integer.parseInt(token.nextToken());
            }

            comb(0, 0);
            sb.append("\n");
            token = new StringTokenizer(br.readLine());
        }

        System.out.println(sb);
    }
}
