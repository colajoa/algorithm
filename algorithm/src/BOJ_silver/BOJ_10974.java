package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_10974 {
    static int N;
    static int[] selected;
    static boolean[] isSelected;
    static StringBuilder sb = new StringBuilder();

    static void perm(int depth) {
        if (depth == N) {
            for (int n = 0; n < N; n++) {
                sb.append(selected[n]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i < N + 1; i++) {

            if (isSelected[i])
                continue;

            isSelected[i] = true;
            selected[depth] = i;
            perm(depth + 1);
            isSelected[i] = false;

        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        selected = new int[N];
        isSelected = new boolean[N + 1];

        perm(0);

        System.out.println(sb);
    }
}
