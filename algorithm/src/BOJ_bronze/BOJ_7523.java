package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_7523 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T + 1; t++) {
            token = new StringTokenizer(br.readLine());
            long N = Long.parseLong(token.nextToken());
            long M = Long.parseLong(token.nextToken());

            sb.append("Scenario #").append(t).append(":\n");

            long ans = 0;

            if (N < 0 && M < 0) {
                ans -= (-N * (-N + 1)) / 2;
                ans += (-(M + 1) * -M) / 2;
            } else if (N > 0 && M > 0) {
                ans += ((M + 1) * M) / 2;
                ans -= ((N - 1) * N) / 2;
            } else {
                ans -= ((N - 1) * N) / 2;
                ans += (M * (M + 1)) / 2;
            }

            sb.append(ans).append("\n");
            sb.append("\n");

        }
        System.out.println(sb);
    }
}
