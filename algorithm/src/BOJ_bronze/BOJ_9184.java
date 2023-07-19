package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_9184 {
    static int[][][] arr = new int[21][21][21];

    public static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }
        if (arr[a][b][c] != 0) {
            return arr[a][b][c];
        } else {
            if (a > 20 || b > 20 || c > 20) {
                return arr[20][20][20] = w(20, 20, 20);
            } else if (a < b && b < c) {
                return arr[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            } else {
                return arr[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        while (true) {
            token = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
        }

    }
}
