package BOJ_bronze;

import java.io.*;

public class BOJ_2903 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println((long) Math.pow(Math.pow(2, N) + 1, 2));
    }
}