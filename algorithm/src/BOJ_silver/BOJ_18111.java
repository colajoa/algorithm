package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_18111 {
    static int N, M, B;
    static int[][] ground;
    static int ansTime = Integer.MAX_VALUE, ansHeight = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        B = Integer.parseInt(token.nextToken());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        ground = new int[N][M];

        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                int num = ground[n][m] = Integer.parseInt(token.nextToken());

                max = Math.max(max, num);
                min = Math.min(min, num);
            }
        }

        for (int i = min; i <= max; i++) {

            int invent = B;
            int time = 0;

            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    int gap = ground[n][m] - i;

                    if (gap > 0) {
                        time += gap * 2;
                        invent += gap;
                    } else if (gap < 0) {
                        time += (gap * -1);
                        invent -= (gap * -1);
                    }
                }
            }

            if (invent >= 0) {
                // 같은 시간이면 땅이 가장 높은 것을 출력
                if (ansTime >= time) {
                    ansTime = time;
                    ansHeight = i;
                }
            }
        }

        System.out.println(ansTime + " " + ansHeight);
    }
}
