package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_1259 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals("0"))
                break;
            String ans = "yes";
            for (int i = 0; i < str.length() / 2; i++) {
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    ans = "no";
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
