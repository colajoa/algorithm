package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_10773 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int[] nums = new int[K];
        int top = -1;
        int sum = 0;
        for (int k = 0; k < K; k++) {
            int num = Integer.parseInt(br.readLine());
            if (top == -1 && num == 0) {
                continue;
            } else if (num == 0) {
                sum -= nums[top];
                nums[top--] = 0;
            } else if (num != 0) {
                nums[++top] = num;
                sum += num;
            }
        }
        System.out.println(sum);
    }
}
