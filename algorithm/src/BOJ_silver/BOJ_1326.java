package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_1326 {
    static int N, A, B, ans = -1;
    static int[] bridge;
    static boolean[] visited;

    static class Jump {
        int p, cnt;

        public Jump(int p, int cnt) {
            this.p = p;
            this.cnt = cnt;
        }
    }

    static void bfs(int start) {
        Queue<Jump> q = new ArrayDeque<>();
        q.add(new Jump(start, 0));
        visited[start] = true;
        while (!q.isEmpty()) {
            Jump now = q.poll();

            if (now.p == B) {
                ans = now.cnt;
                return;
            }

            int jump = bridge[now.p];
            for (int n = 1; now.p + (n * jump) <= N; n++) {
                int np = now.p + (n * jump);
                if (!visited[np]) {
                    visited[np] = true;
                    q.add(new Jump(np, now.cnt + 1));
                }
            }

            for (int n = 1; now.p - (n * jump) >= 1; n++) {
                int np = now.p - (n * jump);
                if (!visited[np]) {
                    visited[np] = true;
                    q.add(new Jump(np, now.cnt + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());

        bridge = new int[N + 1];
        token = new StringTokenizer(br.readLine());
        visited = new boolean[N + 1];
        for (int n = 1; n < N + 1; n++) {
            bridge[n] = Integer.parseInt(token.nextToken());
        }

        token = new StringTokenizer(br.readLine());

        A = Integer.parseInt(token.nextToken());
        B = Integer.parseInt(token.nextToken());

        bfs(A);

        System.out.println(ans);
    }
}