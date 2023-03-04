package swea;

import java.io.*;
import java.util.*;

public class swea_1486 {
    static int N, B, S[], ans;

    static void subset() {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            B = Integer.parseInt(token.nextToken());
            ans = Integer.MAX_VALUE;
            token = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                S[i] = Integer.parseInt(token.nextToken());
            }

        }
    }
}
