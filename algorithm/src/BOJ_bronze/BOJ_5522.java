package BOJ_bronze;

import java.io.*;
import java.math.BigInteger;

public class BOJ_5522 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger num = new BigInteger("0");

        for (int i = 0; i < 5; i++) {
            num = num.add(new BigInteger(br.readLine()));
        }

        System.out.println(num);
    }
}
