package BOJ_bronze;

import java.io.*;

public class BOJ_1371 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] alpha = new int[26];

        String str = "";
        while (((str = br.readLine()) != null)) {
            int len = str.length();

            for (int l = 0; l < len; l++) {
                char c = str.charAt(l);
                if (c == ' ')
                    continue;
                alpha[c - 'a'] += 1;
            }
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if (alpha[i] > max)
                max = alpha[i];
        }

        for (int i = 0; i < 26; i++) {
            if (alpha[i] == max)
                sb.append((char) ('a' + i));
        }
        System.out.println(sb);
    }
}
