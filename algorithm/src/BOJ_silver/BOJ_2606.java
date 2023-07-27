package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2606 {
    static int N, cnt = 0;
    static boolean[] visited;
    static boolean[][] coms;

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int n = 1; n < N + 1; n++) {
                if (!visited[n] && coms[now][n]) {
                    visited[n] = true;
                    q.add(n);
                    cnt += 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        coms = new boolean[N + 1][N + 1];

        int M = Integer.parseInt(br.readLine());
        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());

            coms[from][to] = coms[to][from] = true;
        }
        bfs();
        System.out.println(cnt);
    }
}
