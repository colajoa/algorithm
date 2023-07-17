package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_14215 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());
        int max = Math.max(a, Math.max(c, b));
        int sum = a + b + c;
        int minus = sum - max;
        if (minus > max) {
            System.out.println(sum);
        } else {
            System.out.println((minus * 2) - 1);
        }
    }
}