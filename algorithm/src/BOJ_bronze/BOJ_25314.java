package BOJ_bronze;

import java.io.*;

public class BOJ_25314 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N / 4; n++) {
            sb.append("long").append(" ");
        }
        sb.append("int");

        System.out.println(sb);
    }
}