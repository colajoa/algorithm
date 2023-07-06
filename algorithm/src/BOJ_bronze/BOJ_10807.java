package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_10807 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        int N = Integer.parseInt(br.readLine());
        token = new StringTokenizer(br.readLine());

        int[] nums = new int[201];

        for (int n = 0; n < N; n++) {
            int num = Integer.parseInt(token.nextToken());
            if (num < 0) {
                num = num * -1 + 100;
            }
            nums[num] += 1;
        }

        int num = Integer.parseInt(br.readLine());
        num = num < 0 ? num * -1 + 100 : num;
        System.out.println(nums[num]);
    }
}