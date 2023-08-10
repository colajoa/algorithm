package BOJ_bronze;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BOJ_1271 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        BigInteger n = new BigInteger(token.nextToken());
        BigInteger m = new BigInteger(token.nextToken());

        System.out.println(n.divide(m));
        System.out.println(n.mod(m));
    }
}
