package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_2577 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int mul = A * B * C;
        int[] num = new int[10];

        String str = mul + "";
        int len = str.length();
        for (int i = 0; i < len; i++) {
            int n = str.charAt(i) - '0';
            num[n] += 1;
        }

        for (int n = 0; n < 10; n++) {
            sb.append(num[n]).append("\n");
        }

        System.out.println(sb);
    }
}
