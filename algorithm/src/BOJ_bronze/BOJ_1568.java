package BOJ_bronze;

import java.io.*;

public class BOJ_1568 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        int time = 0;

        while (N > 0) {

            if (N < cnt) {
                cnt = 1;
            }

            N -= cnt;
            cnt += 1;
            time += 1;
        }

        System.out.println(time);
    }
}
