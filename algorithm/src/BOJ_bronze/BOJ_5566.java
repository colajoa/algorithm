package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_5566 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        int[] map = new int[N + 1];

        for (int n = 1; n < N + 1; n++) {
            map[n] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        int start = 1;
        for (int m = 0; m < M; m++) {
            ans += 1;
            int dice = Integer.parseInt(br.readLine());

            start += dice;

            if (start >= N) {
                System.out.println(ans);
                for (int end = m + 1; end < M; end++) {
                    br.readLine();
                }
                break;
            }

            int move = map[start];
            start += move;

            if (start >= N) {
                System.out.println(ans);
                for (int end = m + 1; end < M; end++) {
                    br.readLine();
                }
                break;
            } else if (start < 1) {
                start = 1;
            }
        }
    }
}
