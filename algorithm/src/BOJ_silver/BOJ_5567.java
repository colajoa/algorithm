package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_5567 {
    static int N, M, cnt = 0;
    static List<Integer>[] friends;
    static boolean[] visited;

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        visited[1] = true;
        q.add(new int[] { 1, 0 });

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[1] <= 2) {
                cnt += 1;
            }

            for (int next : friends[now[0]]) {
                if (!visited[next] && now[1] + 1 <= 2) {
                    q.add(new int[] { next, now[1] + 1 });
                    visited[next] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        friends = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int n = 1; n < N + 1; n++) {
            friends[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());

            friends[from].add(to);
            friends[to].add(from);
        }

        bfs();

        System.out.println(cnt - 1);
    }
}
