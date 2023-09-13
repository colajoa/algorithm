package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_1240 {
    static int N, M;
    static int ans;
    static List<int[]>[] tree;
    static Queue<int[]> q = new ArrayDeque<>();
    static boolean[] visited;

    static void bfs(int to) {
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == to) {
                ans = now[1];
                q.clear();
                return;
            }

            for (int[] node : tree[now[0]]) {
                if (!visited[node[0]]) {
                    q.add(new int[] { node[0], now[1] + node[1] });
                    visited[node[0]] = true;
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

        tree = new ArrayList[N + 1];

        for (int n = 1; n < N + 1; n++) {
            tree[n] = new ArrayList<>();
        }

        for (int n = 0; n < N - 1; n++) {
            token = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());
            int dis = Integer.parseInt(token.nextToken());

            tree[from].add(new int[] { to, dis });
            tree[to].add(new int[] { from, dis });
        }

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());

            visited = new boolean[N + 1];
            visited[from] = true;
            ans = 0;
            q.add(new int[] { from, 0 });
            bfs(to);
            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
