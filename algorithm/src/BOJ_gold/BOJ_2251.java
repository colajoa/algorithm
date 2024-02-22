package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_2251 {
    static int[] basket = new int[3];
    static boolean[][] visited = new boolean[201][201];
    static boolean[] ans = new boolean[201];
    static int[] send = { 0, 0, 1, 1, 2, 2 };
    static int[] receive = { 1, 2, 0, 2, 0, 1 };
    static Queue<Basket> q = new ArrayDeque<>();

    static class Basket {
        int A, B;

        public Basket(int A, int B) {
            this.A = A;
            this.B = B;
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Basket now = q.poll();

            int A = now.A;
            int B = now.B;
            int C = basket[2] - A - B;

            for (int d = 0; d < 6; d++) {
                int[] next = { A, B, C };
                next[receive[d]] += next[send[d]];
                next[send[d]] = 0;

                if (next[receive[d]] > basket[receive[d]]) {
                    next[send[d]] = next[receive[d]] - basket[receive[d]];
                    next[receive[d]] = basket[receive[d]];
                }

                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.add(new Basket(next[0], next[1]));
                    if (next[0] == 0) {
                        ans[next[2]] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int n = 0; n < 3; n++) {
            basket[n] = Integer.parseInt(token.nextToken());
        }

        visited[0][0] = true;
        q.add(new Basket(0, 0));
        ans[basket[2]] = true;
        bfs();

        for (int i = 0; i < 201; i++) {
            if (ans[i]) {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
}
