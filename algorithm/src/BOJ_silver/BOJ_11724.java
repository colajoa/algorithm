package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_11724 {
    static int N, M, ans = 0;
    static int[][] edge;
    static boolean[] visited;

    static void search(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int from = q.poll();

            for (int to = 1; to <= N; to++) {
                if (edge[from][to] == 1 && !visited[to]) {
                    visited[to] = true;
                    q.add(to);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        edge = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());

            edge[from][to] = edge[to][from] = 1;
        }

        for (int n = 1; n <= N; n++) {
            if (!visited[n]) {
                search(n);
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}
