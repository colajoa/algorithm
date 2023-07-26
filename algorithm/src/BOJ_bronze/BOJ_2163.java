package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_2163 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());

        System.out.println((M - 1) + (N - 1) * M);
    }
}
