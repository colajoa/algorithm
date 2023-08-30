package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_15964 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(token.nextToken());
        long B = Integer.parseInt(token.nextToken());

        System.out.println((A + B) * (A - B));
    }
}
