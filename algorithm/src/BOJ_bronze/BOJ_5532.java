package BOJ_bronze;

import java.io.*;

public class BOJ_5532 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());

        int kor = A / C;
        int math = B / D;

        if (A % C != 0) {
            kor += 1;
        }

        if (B % D != 0) {
            math += 1;
        }

        int max = Math.max(math, kor);

        System.out.println(L - max);
    }
}
