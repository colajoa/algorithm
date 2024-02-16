package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_18352 {
    static int N, M, K, X;
    static int[] ans;
    static boolean[] visited;
    static List<Integer>[] road;
    static Queue<Integer> q = new ArrayDeque<>();

    static void bfs() {
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : road[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    ans[next] = ans[now] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());
        X = Integer.parseInt(token.nextToken());

        road = new ArrayList[N + 1];
        ans = new int[N + 1];
        visited = new boolean[N + 1];
        for (int n = 1; n < N + 1; n++) {
            road[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());

            road[from].add(to);
        }

        visited[X] = true;
        q.add(X);
        bfs();

        for (int n = 1; n < N + 1; n++) {
            if (ans[n] == K) {
                sb.append(n).append("\n");
            }
        }

        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}
