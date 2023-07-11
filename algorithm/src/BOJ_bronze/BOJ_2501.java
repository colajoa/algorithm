package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_2501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int K = Integer.parseInt(token.nextToken());

        int cnt = 0;
        int i;
        for (i = 1; i <= N; i++) {
            if (N % i == 0) {
                cnt += 1;
            }
            if (cnt == K)
                break;
        }
        System.out.println(i >= K ? 0 : i);
    }
}