package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_14248 {
    static int N, cnt = 0;
    static int[] map;
    static boolean[] visited;

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[start] = true;
        cnt += 1;
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = -1; i < 2; i += 2) {
                int next = now + (map[now] * i);
                if (next > 0 && next <= N && !visited[next]) {
                    visited[next] = true;
                    cnt += 1;
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1];
        visited = new boolean[N + 1];

        token = new StringTokenizer(br.readLine());
        for (int n = 1; n < N + 1; n++) {
            map[n] = Integer.parseInt(token.nextToken());
        }

        int start = Integer.parseInt(br.readLine());

        bfs(start);

        System.out.println(cnt);
    }
}
