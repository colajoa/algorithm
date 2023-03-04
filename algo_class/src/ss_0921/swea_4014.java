package ss_0921;

import java.io.*;
import java.util.*;

public class swea_4014 {
    static int N, X;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            X = Integer.parseInt(token.nextToken());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                token = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                }
            }
        }

    }
}
