package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2669 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        int[][] map = new int[101][101];
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            token = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(token.nextToken());
            int y1 = Integer.parseInt(token.nextToken());
            int x2 = Integer.parseInt(token.nextToken());
            int y2 = Integer.parseInt(token.nextToken());

            for (int r = y1; r < y2; r++) {
                for (int c = x1; c < x2; c++) {
                    map[r][c] = 1;
                }
            }
        }

        for (int r = 0; r < 101; r++) {
            for (int c = 0; c < 101; c++) {
                if (map[r][c] == 1) {
                    sum += 1;
                }
            }
        }

        System.out.println(sum);
    }
}
