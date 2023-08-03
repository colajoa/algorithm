package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_2530 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(token.nextToken());
        int M = Integer.parseInt(token.nextToken());
        int S = Integer.parseInt(token.nextToken());

        int time = Integer.parseInt(br.readLine());

        H = H + time / 3600;

        time %= 3600;

        M = M + time / 60;

        time %= 60;

        S = S + time;

        if (S > 59) {
            S -= 60;
            M += 1;
        }

        if (M > 59) {
            M -= 60;
            H += 1;
        }

        H = H > 23 ? H % 24 : H;

        System.out.println(H + " " + M + " " + S);
    }
}
