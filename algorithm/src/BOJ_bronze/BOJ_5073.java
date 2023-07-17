package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_5073 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        while (true) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());
            int max = Math.max(a, Math.max(c, b));
            int sum = a + b + c;
            if (a == 0) {
                break;
            }
            if (sum - max <= max) {
                System.out.println("Invalid");
            } else if (a == b && b == c && c == a) {
                System.out.println("Equilateral");
            } else if (a != b && b != c && c != a) {
                System.out.println("Scalene");
            } else {
                System.out.println("Isosceles");
            }
        }
    }
}
