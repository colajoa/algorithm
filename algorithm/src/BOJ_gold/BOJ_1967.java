package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_1967 {
    static int N;
    static int[] weight;
    static boolean[] visited;
    static List<Node>[] node;
    static Queue<Integer> q = new ArrayDeque<>();

    static void bfs(int start) {
        visited[start] = true;
        q.add(start);
        while (!q.isEmpty()) {
            int now = q.poll();

            for (Node next : node[now]) {
                if (!visited[next.vertex]) {
                    visited[next.vertex] = true;
                    q.add(next.vertex);
                    weight[next.vertex] = weight[now] + next.weight;
                }
            }
        }
    }

    static class Node {
        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());
        node = new ArrayList[N + 1];

        for (int n = 1; n < N + 1; n++) {
            node[n] = new ArrayList<>();
        }

        for (int n = 1; n < N; n++) {
            token = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(token.nextToken());
            int from = Integer.parseInt(token.nextToken());
            int weight = Integer.parseInt(token.nextToken());

            node[to].add(new Node(from, weight));
            node[from].add(new Node(to, weight));
        }

        visited = new boolean[N + 1];
        weight = new int[N + 1];
        int max = 1;
        bfs(1);

        for (int n = 2; n < N + 1; n++) {
            if (weight[max] < weight[n]) {
                max = n;
            }
        }

        visited = new boolean[N + 1];
        weight = new int[N + 1];
        bfs(max);
        Arrays.sort(weight);
        System.out.println(weight[N]);
    }
}
