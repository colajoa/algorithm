package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_23971 {
    static int H, W, N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        H = Integer.parseInt(token.nextToken());
        W = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken()) + 1;
        M = Integer.parseInt(token.nextToken()) + 1;

        long r = 1;
        long c = 1;

        for (int ri = N + 1; ri <= H; ri += N) {
            r += 1;
        }
        for (int ci = M + 1; ci <= W; ci += M) {
            c += 1;
        }
        System.out.println(r * c);
    }
}
