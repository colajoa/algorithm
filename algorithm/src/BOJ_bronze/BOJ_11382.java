package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_11382 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        long sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += Long.parseLong(token.nextToken());
        }
        System.out.println(sum);
    }
}
