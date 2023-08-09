package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_5430 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String command = br.readLine();
            int N = Integer.parseInt(br.readLine());

            token = new StringTokenizer(br.readLine(), "[,]");
            int[] nums = new int[N];
            for (int n = 0; n < N; n++) {
                nums[n] = Integer.parseInt(token.nextToken());
            }

            int len = command.length();

            int front = 0;
            int tail = N - 1;
            int left = N;
            boolean flag = true;
            char error = '0';
            for (int i = 0; i < len; i++) {
                if (command.charAt(i) == 'R') {
                    flag = !flag;
                } else {
                    if (left == 0) {
                        error = 'e';
                        break;
                    } else {
                        if (flag) {
                            nums[front++] = 0;
                        } else {
                            nums[tail--] = 0;
                        }
                        left--;
                    }
                }
            }
            if (error == 'e') {
                sb.append("error").append("\n");
            } else if (left == 0) {
                sb.append("[]").append("\n");
            } else {
                sb.append("[");
                if (flag) {

                    for (int i = front; i < tail; i++) {
                        sb.append(nums[i]).append(",");
                    }
                    sb.append(nums[tail]);
                } else {
                    for (int i = tail; i > front; i--) {
                        sb.append(nums[i]).append(",");
                    }
                    sb.append(nums[front]);
                }
                sb.append("]").append("\n");
            }
        }
        System.out.println(sb);
    }
}
