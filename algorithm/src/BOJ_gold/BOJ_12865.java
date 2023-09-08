package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_12865 {
    static int N, K;
    static int[] weight;
    static int[] values;
    static int[][] ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        weight = new int[N + 1];
        values = new int[N + 1];

        ans = new int[N + 1][K + 1];
        for (int n = 1; n < N + 1; n++) {
            token = new StringTokenizer(br.readLine());

            int W = Integer.parseInt(token.nextToken());
            int V = Integer.parseInt(token.nextToken());

            weight[n] = W;
            values[n] = V;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int w = 1; w < K + 1; w++) {
                if (weight[i] > w) {
                    ans[i][w] = ans[i - 1][w];
                } else {
                    ans[i][w] = Math.max(values[i] + ans[i - 1][w - weight[i]], ans[i - 1][w]);
                }
            }
        }
        System.out.println(ans[N][K]);
    }
}
