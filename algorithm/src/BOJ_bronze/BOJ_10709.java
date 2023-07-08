package BOJ_bronze;

import java.io.*;

public class BOJ_10709 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] chars = new char[5][15];

        for (int n = 0; n < 5; n++) {
            String str = br.readLine();
            for (int m = 0; m < str.length(); m++) {
                chars[n][m] = str.charAt(m);
            }
        }

        for (int m = 0; m < 15; m++) {
            for (int n = 0; n < 5; n++) {

                if (chars[n][m] != 0) {
                    sb.append(chars[n][m]);
                }
            }
        }
        System.out.println(sb);
    }
}