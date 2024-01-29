package BOJ_silver;

import java.io.*;

public class BOJ_14729 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] student = new int[100001];
        for (int n = 0; n < N; n++) {
            int num = (int) (Double.parseDouble(br.readLine()) * 1000);
            student[num] += 1;
        }

        int cnt = 0;
        for (int i = 0; i < 100001 && cnt != 7; i++) {
            if (student[i] != 0) {
                for (int n = 0; n < student[i] && cnt != 7; n++) {
                    System.out.printf("%.3f\n", i * 0.001);

                    cnt += 1;
                }
            }
        }
    }
}
