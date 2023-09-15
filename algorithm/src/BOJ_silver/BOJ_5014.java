package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_5014 {
    static int F, S, G, U, D;
    static int ans = -1;
    static boolean[] visited;
    static int[] steps = new int[2];

    static class Ele {
        int floor;
        int cnt;

        public Ele(int floor, int cnt) {
            this.floor = floor;
            this.cnt = cnt;
        }
    }

    static void bfs() {
        Queue<Ele> q = new ArrayDeque<>();
        q.add(new Ele(S, 0));
        visited[S] = true;

        while (!q.isEmpty()) {
            Ele now = q.poll();

            if (now.floor == G) {
                ans = now.cnt;
                return;
            }

            for (int i = 0; i < 2; i++) {
                int next = now.floor + steps[i];

                if (next > 0 && next <= F && !visited[next]) {
                    q.add(new Ele(next, now.cnt + 1));
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        F = Integer.parseInt(token.nextToken());
        S = Integer.parseInt(token.nextToken());
        G = Integer.parseInt(token.nextToken());
        U = Integer.parseInt(token.nextToken());
        D = Integer.parseInt(token.nextToken());

        steps[0] = U;
        steps[1] = -D;

        visited = new boolean[F + 1];

        bfs();

        if (ans == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(ans);
        }
    }
}
