package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2822 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int[] sort = new int[9];
        int[] org = new int[9];

        for (int i = 1; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            // sum += num;
            sort[i] = num;
            org[i] = num;
        }

        Arrays.sort(sort);

        for (int n = 1; n < 9; n++) {
            for (int i = 4; i < 9; i++) {
                if (org[n] == sort[i]) {
                    sb.append(n).append(" ");
                    sum += sort[i];
                    break;
                }
            }
        }
        System.out.println(sum);
        System.out.println(sb);
    }
}
