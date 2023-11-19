package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_14218 {
    static int N, M, Q, q;
    static List<Integer>[] road;
    static int[][] ans;
    static Queue<Integer> queue = new ArrayDeque<>();

    static void bfs() {
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : road[now]) {
                if (ans[q][next] == 0) {
                    ans[q][next] = ans[q][now] + 1;
                    queue.add(next);
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

        road = new ArrayList[N + 1];

        for (int n = 1; n < N + 1; n++) {
            road[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(token.nextToken());
            int from = Integer.parseInt(token.nextToken());

            road[to].add(from);
            road[from].add(to);
        }

        Q = Integer.parseInt(br.readLine());
        ans = new int[Q][N + 1];

        for (q = 0; q < Q; q++) {
            token = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(token.nextToken());
            int j = Integer.parseInt(token.nextToken());

            road[i].add(j);
            road[j].add(i);

            ans[q][1] = 1;
            queue.add(1);
            bfs();

            for (int n = 1; n < N + 1; n++) {
                sb.append(ans[q][n] - 1).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
