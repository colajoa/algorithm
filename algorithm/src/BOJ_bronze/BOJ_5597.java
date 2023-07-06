package BOJ_bronze;

import java.io.*;

public class BOJ_5597 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] student = new int[31];
        for (int n = 0; n < 28; n++) {
            student[Integer.parseInt(br.readLine())] = 1;
        }

        for (int n = 1; n <= 30; n++) {
            if (student[n] == 0)
                System.out.println(n);
        }
    }
}