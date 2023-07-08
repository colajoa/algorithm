package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_2566 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        int max = -1;
        int x = -1, y = -1;
        for (int n = 1; n <= 9; n++) {
            token = new StringTokenizer(br.readLine());
            for (int m = 1; m <= 9; m++) {

                int num = Integer.parseInt(token.nextToken());
                if (num > max) {
                    max = num;
                    x = n;
                    y = m;
                }
            }
        }

        System.out.println(max + "\n" + x + " " + y);
    }
}
