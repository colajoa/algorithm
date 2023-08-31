package BOJ_bronze;

import java.io.*;

public class BOJ_2754 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        double ans = 0.0;

        switch (str.charAt(0)) {
            case 'A':
                ans = 4.0;
                break;
            case 'B':
                ans = 3.0;
                break;
            case 'C':
                ans = 2.0;
                break;
            case 'D':
                ans = 1.0;
                break;
            case 'F':
                System.out.println(ans);
                System.exit(0);
        }

        switch (str.charAt(1)) {
            case '+':
                ans += 0.3;
                break;
            case '-':
                ans -= 0.3;
                break;
        }

        System.out.println(ans);
    }
}
