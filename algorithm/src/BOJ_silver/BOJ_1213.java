package BOJ_silver;

import java.io.*;

public class BOJ_1213 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        int len = str.length();
        int[] num = new int[26];
        for (int n = 0; n < len; n++) {
            num[str.charAt(n) - 'A'] += 1;
        }

        int cnt = 0;
        for (int n = 0; n < 26; n++) {
            if (num[n] % 2 == 1) {
                cnt += 1;
            }
        }

        if (cnt > 1) {
            sb.append("I'm Sorry Hansoo");
        } else {
            int flag = -1;
            for (int n = 0; n < 26; n++) {
                if (num[n] % 2 == 1) {
                    flag = n;
                }
                for (int m = 0; m < num[n] / 2; m++) {
                    sb.append((char) (n + 'A'));
                }
            }

            if (flag != -1) {
                sb.append((char) (flag + 'A'));
            }

            for (int n = 25; n > -1; n--) {
                for (int m = 0; m < num[n] / 2; m++) {
                    sb.append((char) (n + 'A'));
                }
            }
        }
        System.out.println(sb);
    }
}
