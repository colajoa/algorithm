package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_1475 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int len = N.length();

        int[] nums = new int[10];

        for (int i = 0; i < len; i++) {
            nums[N.charAt(i) - '0'] += 1;
        }

        int max = -1;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9)
                continue;

            max = Math.max(max, nums[i]);
        }

        int sixNine = nums[6] + nums[9];

        if (sixNine % 2 == 0) {
            sixNine /= 2;
        } else {
            sixNine = (sixNine / 2) + 1;
        }

        System.out.println(Math.max(sixNine, max));
    }
}
