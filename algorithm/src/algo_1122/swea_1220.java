package algo_1122;

import java.io.*;
import java.util.*;

public class swea_1220 {
    static int N, ans;
    static int[][] map;
    static int[] dr = { 0, -1, 1 };

    static void drop() {
        for (int c = 0; c < N; c++) {
            for (int r = 0; r < N; r++) {

                int dir = map[r][c];
                boolean meet = false;
                int nr = r;
                while (!meet) {
                    nr += dr[dir];

                    if (map[nr][c] ) {

                    }
                }

            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            ans = 0;
            for (int r = 0; r < N; r++) {
                token = new StringTokenizer(br.readLine());

                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(token.nextToken());
                }
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }

        System.out.println(sb);
    }
