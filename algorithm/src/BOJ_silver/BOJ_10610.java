package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_10610 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[10];
        int isPossible = 0;
        for (int i = 0; i < str.length(); i++) {
            nums[str.charAt(i) - '0'] += 1;
            isPossible += str.charAt(i) - '0';
        }
        if (nums[0] > 0 && isPossible % 3 == 0) {
            for (int i = 9; i > -1; i--) {
                for (int n = 0; n < nums[i]; n++) {
                    sb.append(i);
                }
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}
