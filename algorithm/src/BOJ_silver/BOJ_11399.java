package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_11399 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        token = new StringTokenizer(br.readLine());

        int[] waiting = new int[1001];
        for (int n = 0; n < N; n++) {
            int time = Integer.parseInt(token.nextToken());
            waiting[time] += 1;
        }

        for (int i = 1; i < 1001; i++) {
            if (waiting[i] != 0) {
                for (int w = waiting[i]; w > 0; w--) {
                    ans += i * N;
                    N -= 1;
                }
            }
        }

        System.out.println(ans);
    }
}
