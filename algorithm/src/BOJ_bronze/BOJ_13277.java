package BOJ_bronze;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BOJ_13277 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        BigInteger A = new BigInteger(token.nextToken());
        BigInteger B = new BigInteger(token.nextToken());

        System.out.println(A.multiply(B));
    }
}
