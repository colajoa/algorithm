package ss_1020;

import java.io.*;
import java.util.*;

public class Baekjoon_9079 {
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int t = 0; t < N; t++) {

            for (int r = 0; r < N; r++) {
                token = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(token.nextToken());
                }
            }
            
        }

    }
}