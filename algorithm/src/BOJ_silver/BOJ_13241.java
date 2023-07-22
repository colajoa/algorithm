package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_13241 {
    static long GCD(long a, long b) {
        if (a % b == 0)
            return b;
        return GCD(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(token.nextToken());
        long B = Integer.parseInt(token.nextToken());

        System.out.println((A * B) / GCD(A, B));
    }
}