package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_2914 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(token.nextToken());
        int I = Integer.parseInt(token.nextToken());

        System.out.println((A * (I - 1)) + 1);
    }
}
