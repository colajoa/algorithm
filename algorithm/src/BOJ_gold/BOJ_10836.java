package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_10836 {
    static int M, N;
    static int[][] map;
    static int[] up;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        token = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());

        map = new int[M][M];
        up = new int[(2 * M) - 1];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < M; c++) {
                map[r][c] = 1;
            }
        }

        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine(), " ");
            int idx = 0;
            int size = 0;
            while (token.hasMoreTokens()) {
                int I = Integer.parseInt(token.nextToken());
                for (int i = 0; i < I; i++) {
                    up[idx++] = size;
                }
                size += 1;
            }
            idx = 0;
            for (int r = M - 1; r > -1; r--) {
                map[r][0] += up[idx++];
            }

            for (int c = 1; c < M; c++) {
                map[0][c] += up[idx++];
            }
        }

        for (int r = 0; r < M; r++) {
            System.out.println(Arrays.toString(map[r]));
        }
    }
}
