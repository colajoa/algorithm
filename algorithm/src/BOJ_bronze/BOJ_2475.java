package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_2475 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(token.nextToken());
            sum += num * num;
        }

        System.out.println(sum % 10);
    }
}
