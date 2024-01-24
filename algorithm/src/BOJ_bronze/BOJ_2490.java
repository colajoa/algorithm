package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_2490 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        Character[] ans = { 'E', 'A', 'B', 'C', 'D' };
        for (int t = 0; t < 3; t++) {
            token = new StringTokenizer(br.readLine());

            int back = 0;

            for (int i = 0; i < 4; i++) {
                if (Integer.parseInt(token.nextToken()) == 0) {
                    back += 1;
                }
            }

            System.out.println(ans[back]);
        }

    }
}
