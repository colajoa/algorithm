package BOJ_bronze;

import java.io.*;

public class BOJ_4470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int n = 1; n < N + 1; n++) {
            sb.append(n).append(". ").append(br.readLine()).append("\n");
        }

        System.out.println(sb);
    }
}
