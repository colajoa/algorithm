package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_11060 {
    static int N;
    static int[] map;
    static boolean[] visited;

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        visited[0] = true;
        q.add(new int[] { 0, 0 });

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == N - 1) {
                return now[1];
            }
            for (int d = 1; d <= map[now[0]]; d++) {
                int next = now[0] + d;

                if (next < N && !visited[next]) {
                    visited[next] = true;
                    q.add(new int[] { next, now[1] + 1 });
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N];
        visited = new boolean[N];
        StringTokenizer token = new StringTokenizer(br.readLine());

        for (int n = 0; n < N; n++) {
            map[n] = Integer.parseInt(token.nextToken());
        }

        System.out.println(bfs());
    }
}
