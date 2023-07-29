package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_1009 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());

            switch (a % 10) {
                case 0:
                    sb.append(10).append("\n");
                    break;

                case 1:
                case 5:
                case 6:
                    sb.append(a % 10).append("\n");
                    break;

                case 2:
                case 3:
                case 7:
                case 8:
                    if (b % 4 == 1) {
                        sb.append(a % 10);
                    } else if (b % 4 == 2) {
                        sb.append((a * a) % 10);
                    } else if (b % 4 == 3) {
                        sb.append((a * a * a) % 10);
                    } else {
                        sb.append((a * a * a * a) % 10);
                    }
                    sb.append('\n');
                    break;

                case 4:
                case 9:
                    if (b % 2 == 0) {
                        sb.append((a * a) % 10);
                    } else {
                        sb.append(a % 10);
                    }
                    sb.append('\n');
                    break;
            }
        }
        System.out.print(sb);
    }
}
