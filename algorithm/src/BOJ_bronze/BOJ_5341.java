package BOJ_bronze;

import java.io.*;

public class BOJ_5341 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = 0;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            sb.append((n * (n + 1)) / 2).append("\n");
        }
        System.out.println(sb);
    }
}
