package BOJ_bronze;

import java.io.*;

public class BOJ_10808 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] ch = new int[26];
        String str = br.readLine();
        int len = str.length();

        for (int n = 0; n < len; n++) {
            ch[str.charAt(n) - 'a'] += 1;
        }

        for (int n = 0; n < 26; n++) {
            sb.append(ch[n]).append(" ");
        }

        System.out.println(sb);
    }
}
