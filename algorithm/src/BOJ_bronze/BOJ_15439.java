package BOJ_bronze;

import java.io.*;

public class BOJ_15439 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println((N - 1) * N);
    }
}