package BOJ_silver;

import java.io.*;

public class BOJ_2751_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] nums = new boolean[2000001];
        int N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            nums[Integer.parseInt(br.readLine()) + 1000000] = true;
        }

        for (int n = 0; n < 2000001; n++) {
            if (nums[n])
                sb.append(n - 1000000).append("\n");
        }
        System.out.println(sb);
    }
}
