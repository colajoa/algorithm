package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_2745 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        String N = token.nextToken();
        int B = Integer.parseInt(token.nextToken());
        int sq = 1;
        int sum = 0;
        for (int n = N.length() - 1; n > -1; n--) {
            int ch = N.charAt(n) - '0';
            if (ch + '0' >= 'A' && ch + '0' <= 'Z') {
                ch = N.charAt(n) - 'A' + 10;
            }
            sum += ch * sq;
            sq *= B;
        }
        System.out.println(sum);
    }
}