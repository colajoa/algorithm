package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_18112 {
    static int L, K;
    static boolean[] visited = new boolean[1024];

    static class Bin {
        int num, cnt;

        public Bin(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    static int bfs() {
        Queue<Bin> q = new ArrayDeque<>();
        q.add(new Bin(L, 0));
        visited[L] = true;

        while (!q.isEmpty()) {
            Bin now = q.poll();

            // System.out.println("num : " + now.num + " cnt : " + now.cnt);
            if (now.num == K) {
                return now.cnt;
            }

            int i = 0;
            for (i = 512; i > 0; i >>= 1) {
                if (now.num / i != 0) {
                    break;
                }
            }

            i >>= 1;

            for (int b = i; b > 0; b >>= 1) {
                int next = now.num ^ b;
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new Bin(next, now.cnt + 1));
                }
            }

            int next = now.num + 1;

            if (next < 1024 && !visited[next]) {
                visited[next] = true;
                q.add(new Bin(next, now.cnt + 1));
            }

            next -= 2;

            if (next > 0 && !visited[next]) {
                visited[next] = true;
                q.add(new Bin(next, now.cnt + 1));
            }
        }

        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        L = Integer.parseInt(br.readLine(), 2);
        K = Integer.parseInt(br.readLine(), 2);

        System.out.println(bfs());
    }
}
