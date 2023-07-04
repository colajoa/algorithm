package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_26099 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long cnt = 0;
        while (N != 0) {
            if (N <= 2) {
                cnt = -1;
                break;
            }

            if (N % 5 == 0) {
                cnt += N / 5;
                break;
            }

            N -= 3;
            cnt += 1;
        }

        System.out.println(cnt);
    }
}
