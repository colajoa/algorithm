package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_1535 {
    static int N;
    static int[] hp;
    static int[] happy;
    static int[][] ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());

        hp = new int[N + 1];
        happy = new int[N + 1];

        ans = new int[N + 1][100];

        token = new StringTokenizer(br.readLine());
        for (int n = 1; n < N + 1; n++) {
            hp[n] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine());
        for (int n = 1; n < N + 1; n++) {
            happy[n] = Integer.parseInt(token.nextToken());
        }

        for (int n = 1; n < N + 1; n++) {
            for (int w = 1; w < 100; w++) {
                if (hp[n] > w) {
                    ans[n][w] = ans[n - 1][w];
                } else {
                    ans[n][w] = Math.max(happy[n] + ans[n - 1][w - hp[n]], ans[n - 1][w]);
                }
            }
        }
        System.out.println(ans[N][99]);
    }
}
