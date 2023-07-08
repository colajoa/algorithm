package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_2738 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int[][] matrix = new int[N][M];

        for (int n = 0; n < N * 2; n++) {
            token = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                matrix[n % N][m] += Integer.parseInt(token.nextToken());
            }
        }
        
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                sb.append(matrix[n][m]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
