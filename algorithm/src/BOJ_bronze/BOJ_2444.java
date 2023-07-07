package BOJ_bronze;

import java.io.*;

public class BOJ_2444 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        for (int n = 0; n < 2 * N - 1; n++) {

            if (cnt <= N) {
                for (int i = 0; i < N - cnt; i++) {
                    sb.append(" ");
                }
                for (int i = 0; i < 2 * cnt - 1; i++) {
                    sb.append("*");
                }
            }

            else {
                for (int i = 0; i < cnt - N; i++) {
                    sb.append(" ");
                }

                for (int i = 0; i < 2 * (2 * N - cnt) - 1; i++) {
                    sb.append("*");
                }
            }
            sb.append("\n");
            cnt += 1;
        }

        System.out.println(sb);
    }
}
