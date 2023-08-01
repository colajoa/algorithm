package BOJ_silver;

import java.io.*;

public class BOJ_1463 {
    static int min = Integer.MAX_VALUE;

    static void search() {

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] calc = new int[1000001];

        calc[1] = 0;
        calc[2] = 1;
        calc[3] = 1;

        for (int i = 4; i <= 1000000; i++) {
            int div3 = Integer.MAX_VALUE;
            int div2 = Integer.MAX_VALUE;
            int minus1 = Integer.MAX_VALUE;

            if (i % 3 == 0) {
                calc[i] = calc[i / 3] + 1;
                div3 = Math.min(calc[i], div3);
            }
            if (i % 2 == 0) {
                calc[i] = calc[i / 2] + 1;
                div2 = Math.min(calc[i], div2);
            }

            for (int s = i - 1; s >= 1; s--) {
                if (s != 0) {
                    calc[i] = calc[s] + i - s;
                    minus1 = Math.min(calc[i], minus1);
                    break;
                }
            }

            calc[i] = Math.min(Math.min(div3, div2), minus1);

        }

        int N = Integer.parseInt(br.readLine());
        System.out.println(calc[N]);
    }
}
