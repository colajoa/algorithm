package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_14217 {
    static int N, M, Q;
    static List<Integer>[] list;
    static int[] visited;
    static Queue<Integer> q = new ArrayDeque<>();

    static void bfs() {
        visited[1] = 1;
        q.add(1);

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
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        list = new ArrayList[N + 1];
        for (int n = 1; n < N + 1; n++) {
            list[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(token.nextToken());
            int from = Integer.parseInt(token.nextToken());

            list[to].add(from);
            list[from].add(to);
        }

        Q = Integer.parseInt(br.readLine());

        for (int q = 0; q < Q; q++) {
            token = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(token.nextToken());
            int i = Integer.parseInt(token.nextToken());
            int j = Integer.parseInt(token.nextToken());

            if (a == 1) {
                list[i].add(j);
                list[j].add(i);
            } else if (a == 2) {
                list[i].remove(Integer.valueOf(j));
                list[j].remove(Integer.valueOf(i));
            }

            visited = new int[N + 1];

            bfs();

            for (int n = 1; n < N + 1; n++) {
                sb.append(visited[n] - 1).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
