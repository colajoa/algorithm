package BOJ_bronze;

import java.io.*;

public class BOJ_28701 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        for (int n = 1; n < N + 1; n++) {
            sum += n;
        }

        System.out.println(sum);

        sum *= sum;
        System.out.println(sum);
        System.out.println(sum);
    }
}
