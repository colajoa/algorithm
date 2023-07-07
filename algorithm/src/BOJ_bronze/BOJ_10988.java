package BOJ_bronze;

import java.io.*;

public class BOJ_10988 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();
        int ans = 1;

        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                ans = 0;
                break;
            }
        }

        System.out.println(ans);
    }
}