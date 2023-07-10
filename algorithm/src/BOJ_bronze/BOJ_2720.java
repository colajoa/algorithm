package BOJ_bronze;

import java.io.*;

public class BOJ_2720 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int money = Integer.parseInt(br.readLine());

            sb.append(money / 25).append(" ");
            money %= 25;
            sb.append(money / 10).append(" ");
            money %= 10;
            sb.append(money / 5).append(" ");
            money %= 5;
            sb.append(money / 1).append("\n");
            money %= 1;

        }
        System.out.println(sb);
    }
}
