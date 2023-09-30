package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_6118 {
    static int N, M, max = -1;
    static List<Integer>[] map;
    static int[] distance;
    static boolean[] visited;
    static Queue<Vertex> q = new ArrayDeque<>();

    static class Vertex {
        int vertex, dis;

        public Vertex(int vertex, int dis) {
            this.vertex = vertex;
            this.dis = dis;
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Vertex now = q.poll();
            for (int next : map[now.vertex]) {
                if (!visited[next]) {
                    max = now.dis + 1 > max ? now.dis + 1 : max;
                    visited[next] = true;
                    distance[next] = now.dis + 1;
                    q.add(new Vertex(next, now.dis + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new ArrayList[N + 1];
        distance = new int[N + 1];

        for (int n = 1; n < N + 1; n++) {
            map[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            map[from].add(to);
            map[to].add(from);
        }

        visited = new boolean[N + 1];
        visited[1] = true;
        q.add(new Vertex(1, 0));
        bfs();

        int min = 0;
        int cnt = 0;
        for (int n = N; n > 1; n--) {
            if (max == distance[n]) {
                cnt += 1;
                min = n;
            }
        }

        System.out.println(min + " " + max + " " + cnt);
    }
}
