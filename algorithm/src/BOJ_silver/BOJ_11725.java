package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_11725 {
    static int N;
    static List<Integer>[] edge;
    static boolean[] visited;
    static int[] ans;
    static Queue<Integer> q = new ArrayDeque<>();

    static void bfs() {
        visited[1] = true;
        q.add(1);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int n : edge[now]) {
                if (!visited[n]) {
                    visited[n] = true;
                    ans[n] = now;
                    q.add(n);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        edge = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        ans = new int[N + 1];
        for (int n = 1; n < N + 1; n++) {
            edge[n] = new ArrayList<>();
        }

        for (int n = 1; n < N; n++) {
            token = new StringTokenizer(br.readLine());
            int parents = Integer.parseInt(token.nextToken());
            int child = Integer.parseInt(token.nextToken());

            edge[child].add(parents);
            edge[parents].add(child);
        }

        bfs();

        for (int n = 2; n < N + 1; n++) {
            sb.append(ans[n]).append("\n");
        }

        System.out.println(sb);
    }
}
