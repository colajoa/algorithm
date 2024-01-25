package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_2947 {
    static StringBuilder sb = new StringBuilder();
    static int[] num = new int[5];

    static void print() {
        for (int i = 0; i < 5; i++) {
            sb.append(num[i]).append(" ");
        }
        sb.append("\n");
    }

    static boolean check() {
        for (int i = 0; i < 5; i++) {
            if (num[i] != i + 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        for (int i = 0; i < 5; i++) {
            num[i] = Integer.parseInt(token.nextToken());
        }

        while (true) {
            for (int i = 0; i < 4; i++) {
                if (num[i] > num[i + 1]) {
                    int temp = num[i];
                    num[i] = num[i + 1];
                    num[i + 1] = temp;
                    print();
                }
            }
            if (check()) {
                break;
            }

        }

        System.out.println(sb);
    }
}
