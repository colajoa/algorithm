package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_9372 {
    static int N, M, ans, v;
    static boolean[] visited;
    static List<Integer>[] country;
    static Queue<Integer> q = new ArrayDeque<>();

    static void bfs() {
        while (!q.isEmpty()) {
            int now = q.poll();

            if (v == N) {
                return;
            }
            for (int next : country[now]) {
                if (!visited[next]) {
                    ans += 1;
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            token = new StringTokenizer(br.readLine());

            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());

            visited = new boolean[N + 1];
            country = new ArrayList[N + 1];
            for (int n = 1; n < N + 1; n++) {
                country[n] = new ArrayList<>();
            }

            for (int m = 0; m < M; m++) {
                token = new StringTokenizer(br.readLine());

                int to = Integer.parseInt(token.nextToken());
                int from = Integer.parseInt(token.nextToken());

                country[to].add(from);
                country[from].add(to);
            }

            ans = 0;
            v = 0;
            for (int n = 1; n < N + 1; n++) {
                if (!visited[n]) {
                    v += 1;
                    visited[n] = true;
                    q.add(n);
                    bfs();
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
