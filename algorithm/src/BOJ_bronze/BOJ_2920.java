package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_2920 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int[] melody = new int[8];
        String ans = "mixed";
        for (int i = 0; i < 8; i++) {
            melody[i] = Integer.parseInt(token.nextToken());
        }

        if (melody[0] == 1) {
            ans = "ascending";
            for (int i = 1; i < 8; i++) {
                if (melody[i - 1] > melody[i]) {
                    ans = "mixed";
                    break;
                }
            }

        } else if (melody[0] == 8) {
            ans = "descending";
            for (int i = 1; i < 8; i++) {
                if (melody[i - 1] < melody[i]) {
                    ans = "mixed";
                    break;
                }
            }

        }
        System.out.println(ans);
    }
}
