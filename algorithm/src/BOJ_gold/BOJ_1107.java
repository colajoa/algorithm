package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_1107 {
    static void changeChannel() {

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        String N = br.readLine();
        int num = Integer.parseInt(N);
        int M = Integer.parseInt(br.readLine());
        boolean[] nums = new boolean[10];

        token = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
            nums[Integer.parseInt(token.nextToken())] = true;
        }

        if (num == 100) {
            System.out.println(0);
        } else if (M == 0) {
            System.out.println(N.length());
        } else if (M == 10) {
            System.out.println(Math.abs(100 - num));
        } else {
            int min = Math.abs(100 - num);

            for (int i = 0; i < 1000000; i++) {
                String str = String.valueOf(i);
                boolean flag = true;

                for (int k = 0; k < str.length(); k++) {
                    if (nums[str.charAt(k) - '0']) {
                        flag = false;
                        break;
                    }
                }
                if (!flag)
                    continue;

                int cnt = str.length() + Math.abs(i - num);
                if (cnt < min)
                    min = cnt;
            }
            System.out.println(min);
        }
    }
}
