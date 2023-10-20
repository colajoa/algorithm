package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_15665 {
    static int N, M, size;
    static int[] ans;

    static List<Integer> list;
    static StringBuilder sb = new StringBuilder();

    static void comb(int depth) {
        if (depth == M) {
            for (int m = 0; m < M; m++) {
                sb.append(ans[m]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int n = 0; n < size; n++) {
            ans[depth] = list.get(n);
            comb(depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        Set<Integer> set = new HashSet<>();
        ans = new int[M];
        token = new StringTokenizer(br.readLine());

        for (int n = 0; n < N; n++) {
            set.add(Integer.parseInt(token.nextToken()));
        }

        Collections.sort(list = new ArrayList<>(set));
        size = list.size();
        comb(0);

        System.out.println(sb);
    }
}
