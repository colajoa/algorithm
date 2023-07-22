package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_1735 {
    static int GCD(int a, int b) {
        if (a % b == 0)
            return b;
        return GCD(b, a % b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        int[][] fraction = new int[2][2];

        for (int i = 0; i < 2; i++) {
            token = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                fraction[i][j] = Integer.parseInt(token.nextToken());
            }
        }

        int sum = (fraction[0][0] * fraction[1][1]) + (fraction[1][0] * fraction[0][1]);
        int product = fraction[0][1] * fraction[1][1];

        int GCD = GCD(product, sum);

        System.out.println(sum / GCD + " " + product / GCD);
    }
}
