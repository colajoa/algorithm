package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_30890 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int X = Integer.parseInt(token.nextToken());
        int Y = Integer.parseInt(token.nextToken());

        int multi = X * Y;

        int[] nums = new int[multi + 1];
        int left = multi / X;
        int right = multi / Y;

        while (left <= multi) {
            nums[left] = 1;
            left += multi / X;
        }

        while (right <= multi) {
            nums[right] += 2;
            right += multi / Y;
        }

        for (int i = 1; i < multi + 1; i++) {
            if (nums[i] != 0) {
                sb.append(nums[i]);
            }
        }
        System.out.println(sb);
    }
}
