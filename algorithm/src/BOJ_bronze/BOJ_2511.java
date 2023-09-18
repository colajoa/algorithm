package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_2511 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int[] A = new int[10];
        int[] B = new int[10];
        char c = 'D';
        boolean flag = true;

        int a = 0;
        int b = 0;

        for (int n = 0; n < 10; n++) {
            A[n] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine());

        for (int n = 0; n < 10; n++) {
            B[n] = Integer.parseInt(token.nextToken());
        }

        for (int n = 0; n < 10; n++) {
            if (A[n] > B[n]) {
                a += 3;
                c = 'A';
                flag = false;
            } else if (A[n] < B[n]) {
                b += 3;
                c = 'B';
                flag = false;
            } else if (A[n] == B[n]) {
                a += 1;
                b += 1;
            }
        }
        System.out.println(a + " " + b);
        if (a > b || (a==b && !flag && c == 'A')) {
            System.out.println("A");
        } else if (a < b || (a == b && !flag && c == 'B')) {
            System.out.println("B");
        } else if (a == b && flag) {
            System.out.println('D');
        }
    }
}
