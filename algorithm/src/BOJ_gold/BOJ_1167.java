package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_1167 {
    static int N;
    static boolean[] visited;
    static int[] distance;
    static List<Vertex>[] vertex;
    static Queue<Integer> q = new ArrayDeque<>();

    static class Vertex {
        int v, dis;

        public Vertex(int v, int dis) {
            this.v = v;
            this.dis = dis;
        }
    }

    static void bfs(int start) {
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();

            for (Vertex next : vertex[now]) {
                if (!visited[next.v]) {
                    visited[next.v] = true;
                    q.add(next.v);
                    distance[next.v] = distance[now] + next.dis;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        distance = new int[N + 1];
        vertex = new ArrayList[N + 1];
        for (int n = 1; n < N + 1; n++) {
            vertex[n] = new ArrayList<>();
        }

        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(token.nextToken());

            int to = 0;
            while ((to = Integer.parseInt(token.nextToken())) != -1) {
                int dis = Integer.parseInt(token.nextToken());

                vertex[from].add(new Vertex(to, dis));
            }
        }
        bfs(1);
        int max = 1;
        for (int n = 2; n < N + 1; n++) {
            if (distance[max] < distance[n]) {
                max = n;
            }
        }
        visited = new boolean[N + 1];
        distance = new int[N + 1];
        bfs(max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }
}
