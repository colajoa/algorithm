package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_5938 {
    static int N, M;
    static boolean[] visited;
    static List<Integer>[] list;
    static Queue<Integer> q = new ArrayDeque<>();

    static void bfs() {
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : list[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
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

        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for (int n = 1; n < N + 1; n++) {
            list[n] = new ArrayList<>();
        }
        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());

            list[from].add(to);
            list[to].add(from);
        }

        visited[1] = true;
        q.add(1);
        bfs();

        for (int n = 1; n < N + 1; n++) {
            if (!visited[n]) {
                sb.append(n).append("\n");
            }
        }

        if (sb.length() == 0) {
            System.out.println(0);
        } else {
            System.out.println(sb);
        }
    }
}
