package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_24446 {
    static int N, M, R;
    static List<Integer>[] list;
    static int[] visited;

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        visited[R] = 1;
        q.add(R);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : list[now]) {
                if (visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());

        list = new ArrayList[N + 1];
        visited = new int[N + 1];

        for (int n = 1; n < N + 1; n++) {
            list[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(token.nextToken());
            int from = Integer.parseInt(token.nextToken());

            list[from].add(to);
            list[to].add(from);
        }

        bfs();

        for (int n = 1; n < N + 1; n++) {
            System.out.println(visited[n] - 1);
        }
    }
}
