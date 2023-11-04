package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_18232 {
    static int N, M, S, E;
    static boolean[] visited;
    static boolean[] isTP;
    static List<Integer>[] tp;

    static class Point {
        int n, time;

        public Point(int n, int time) {
            this.n = n;
            this.time = time;
        }
    }

    static int bfs() {
        Queue<Point> q = new ArrayDeque<>();
        visited[S] = true;
        q.add(new Point(S, 0));

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.n == E) {
                return now.time;
            }

            if (isTP[now.n]) {
                for (int nn : tp[now.n]) {
                    if (!visited[nn]) {
                        visited[nn] = true;
                        q.add(new Point(nn, now.time + 1));
                    }
                }
            }
            for (int i = -1; i < 2; i += 2) {
                int nn = now.n + i;

                if (nn > 0 && nn <= N && !visited[nn]) {
                    visited[nn] = true;
                    q.add(new Point(nn, now.time + 1));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        visited = new boolean[N + 1];
        isTP = new boolean[N + 1];
        tp = new ArrayList[N + 1];

        for (int n = 1; n < N + 1; n++) {
            tp[n] = new ArrayList<>();
        }

        token = new StringTokenizer(br.readLine());

        S = Integer.parseInt(token.nextToken());
        E = Integer.parseInt(token.nextToken());

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(token.nextToken());
            int from = Integer.parseInt(token.nextToken());

            isTP[to] = true;
            isTP[from] = true;

            tp[to].add(from);
            tp[from].add(to);
        }

        System.out.println(bfs());
    }
}
