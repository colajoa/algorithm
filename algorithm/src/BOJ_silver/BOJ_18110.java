package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_18110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] opinions = new int[31];

        for (int n = 0; n < N; n++) {
            opinions[Integer.parseInt(br.readLine())] += 1;
        }

        int s = (int) Math.round(N * 0.15);

        int i = s;
        for (int n = 1; n < 31; n++) {
            if (opinions[n] > 0 && opinions[n] >= i) {
                opinions[n] -= i;
                break;
            } else if (opinions[n] > 0 && opinions[n] < i) {
                i -= opinions[n];
                opinions[n] = 0;
            }
        }

        i = s;
        for (int n = 30; n > -1; n--) {
            if (opinions[n] > 0 && opinions[n] >= i) {
                opinions[n] -= i;
                break;
            } else if (opinions[n] > 0 && opinions[n] < i) {
                i -= opinions[n];
                opinions[n] = 0;
            }
        }

        long sum = 0;
        for (int n = 1; n < 31; n++) {
            if (opinions[n] != 0) {
                sum += n * opinions[n];
            }

        }
        System.out.println(N == 0 ? 0 : Math.round((double) sum / (N - (2 * s))));
    }
}
