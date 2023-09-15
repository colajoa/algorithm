package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_1922_우선순위_큐 {
    static int N, M, ans = 0;
    static List<Computer>[] com;
    static boolean[] visited;

    static class Computer {
        int to;
        int cost;

        public Computer(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static void bfs() {
        Queue<Computer> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.add(new Computer(1, 0));

        while (!q.isEmpty()) {
            Computer now = q.poll();

            if (visited[now.to])
                continue;

            visited[now.to] = true;
            ans += now.cost;

            for (Computer c : com[now.to]) {
                if (!visited[c.to] && now.to != c.to) {
                    q.add(c);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        com = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int n = 1; n < N + 1; n++) {
            com[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());

            com[a].add(new Computer(b, c));
            com[b].add(new Computer(a, c));
        }

        bfs();

        System.out.println(ans);
    }
}
