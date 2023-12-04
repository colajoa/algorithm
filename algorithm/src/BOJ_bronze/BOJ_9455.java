package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_9455 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            token = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(token.nextToken());
            int N = Integer.parseInt(token.nextToken());

            int[][] map = new int[M][N];
            for (int m = 0; m < M; m++) {
                token = new StringTokenizer(br.readLine());
                for (int n = 0; n < N; n++) {
                    map[m][n] = Integer.parseInt(token.nextToken());
                }
            }

            int ans = 0;
            for (int n = 0; n < N; n++) {
                int flag = 0;
                for (int m = M - 1; m > -1; m--) {
                    if (map[m][n] == 0) {
                        flag += 1;
                    } else if (map[m][n] == 1) {
                        ans += flag;
                    }
                }
            }
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
