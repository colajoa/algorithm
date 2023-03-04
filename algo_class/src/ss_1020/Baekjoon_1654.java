package ss_1020;

import java.io.*;
import java.util.*;

public class Baekjoon_1654 {
    static int K, N;
    static int[] cable;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        N = sc.nextInt();

        cable = new int[K];
        for (int i = 0; i < K; i++) {
            cable[i] = sc.nextInt();
        }

        System.out.println(Arrays.toString(cable));
    }
}