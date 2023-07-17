package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_19532 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int x = 0;
        int y = 0;
        int a = Integer.parseInt(token.nextToken());
        int b = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());
        int d = Integer.parseInt(token.nextToken());
        int e = Integer.parseInt(token.nextToken());
        int f = Integer.parseInt(token.nextToken());
        for (x = -999; x <= 999; x++) {
            for (y = -999; y <= 999; y++) {
                if ((a * x) + (b * y) == c && (d * x) + (e * y) == f) {
                    System.out.println(x + " " + y);
                }
            }
        }
    }
}