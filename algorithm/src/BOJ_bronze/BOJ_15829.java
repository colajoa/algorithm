package BOJ_bronze;

import java.util.*;
import java.io.*;

public class BOJ_15829 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long primeNum = 1234567891;
        long sum = 0;
        long sq = 1;
        for (int l = 0; l < L; l++) {
            long c = str.charAt(l) - 'a' + 1;
            sum = (sum + (c * sq)) % primeNum;
            sq = (sq * 31) % primeNum;
        }
        System.out.println(sum);
    }
}
