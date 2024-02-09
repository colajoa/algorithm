package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_10836 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(token.nextToken());
        int N = Integer.parseInt(token.nextToken());

        int size = 2 * M - 1;
        int[] side = new int[size];

        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine(), " ");

            int zero = Integer.parseInt(token.nextToken());
            int one = Integer.parseInt(token.nextToken());
            int two = Integer.parseInt(token.nextToken());

            for (int i = zero; i < zero + one; i++) {
                side[i] += 1;
            }

            for (int i = zero + one; i < size; i++) {
                side[i] += 2;
            }
        }

        for (int i = M - 1; i >= 0; i--) {
            sb.append(side[i] + 1).append(" ");
            for (int j = M; j < size; j++) {
                sb.append(side[j] + 1).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
