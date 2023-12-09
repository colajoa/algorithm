package BOJ_bronze;

import java.io.*;
import java.math.BigInteger;

public class BOJ_26711 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger A = new BigInteger(br.readLine());
        BigInteger B = new BigInteger(br.readLine());

        System.out.println(A.add(B));
    }
}
