package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_18111 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int B = Integer.parseInt(token.nextToken());
        int ansTime = Integer.MAX_VALUE;
        int ansHeight = -1;

        int[][] ground = new int[N][M];

        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                int num = ground[n][m] = Integer.parseInt(token.nextToken());
            }
        }

        for (int i = 0; i <= 256; i++) {

            int invent = 0;
            int remove = 0;

            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    int gap = ground[n][m] - i;

                    if (gap < 0) {
                        invent -= gap;
                    } else {
                        remove += gap;
                    }
                }
            }

            if (remove + B >= invent) {
                // 같은 시간이면 땅이 가장 높은 것을 출력
                int t = 2 * remove + invent;
                if (ansTime >= t) {
                    ansTime = t;
                    ansHeight = i;
                }
            }
        }

        System.out.println(ansTime + " " + ansHeight);
    }
}
