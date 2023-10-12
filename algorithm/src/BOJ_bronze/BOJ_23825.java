package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_23825 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        if (N > M) {
            System.out.println(M / 2);
        } else {
            System.out.println(N / 2);
        }
    }
}
