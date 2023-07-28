package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_11005 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        String str = "";

        int N = Integer.parseInt(token.nextToken());
        int B = Integer.parseInt(token.nextToken());

        while (N != 0) {
            int mod = N % B;
            if (mod > 9) {
                str = (char) ('A' + (mod - 10)) + str;
            } else {
                str = mod + str;
            }
            N /= B;
        }

        System.out.println(str);
    }
}
