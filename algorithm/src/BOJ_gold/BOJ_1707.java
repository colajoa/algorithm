package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_1707 {

    static int V, E;
    static List<Integer>[] edge;
    static int[] colored;
    static StringBuilder sb = new StringBuilder();

    static void check() {
        Queue<Integer> q = new ArrayDeque<>();

        for (int v = 1; v < V + 1; v++) {
            if (colored[v] == 0) {
                colored[v] = 1;
                q.add(v);
            }

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int next : edge[now]) {
                    if (colored[next] == colored[now]) {
                        sb.append("NO\n");
                        return;
                    }
                    if (colored[next] == 0) {
                        q.add(next);

                        if (colored[now] == 1) {
                            colored[next] = colored[now] * -1;
                        } else {
                            colored[next] = 1;
                        }
                    }

                }
            }
        }
        sb.append("YES\n");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        int K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            token = new StringTokenizer(br.readLine());
            V = Integer.parseInt(token.nextToken());
            E = Integer.parseInt(token.nextToken());

            edge = new ArrayList[V + 1];
            for (int v = 1; v < V + 1; v++) {
                edge[v] = new ArrayList<>();
            }

            colored = new int[V + 1];

            for (int e = 0; e < E; e++) {
                token = new StringTokenizer(br.readLine());
                int to = Integer.parseInt(token.nextToken());
                int from = Integer.parseInt(token.nextToken());

                edge[to].add(from);
                edge[from].add(to);
            }

            check();
        }
        System.out.println(sb);
    }
}