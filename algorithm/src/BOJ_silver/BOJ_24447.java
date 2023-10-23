package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_24447 {
    static int N, M, R;
    static List<Integer>[] list;
    static long[][] visited;

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 1;
        visited[R][0] = 1;
        visited[R][1] = cnt++;
        q.add(R);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : list[now]) {
                if (visited[next][0] == 0) {
                    visited[next][0] = visited[now][0] + 1;
                    visited[next][1] = cnt++;
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());

        list = new ArrayList[N + 1];
        visited = new long[N + 1][2];

        for (int n = 1; n < N + 1; n++) {
            list[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(token.nextToken());
            int from = Integer.parseInt(token.nextToken());

            list[to].add(from);
            list[from].add(to);
        }

        for (int n = 1; n < N + 1; n++) {
            Collections.sort(list[n]);
        }

        bfs();

        long sum = 0;
        for (int n = 1; n < N + 1; n++) {
            sum += (visited[n][0] - 1) * visited[n][1];
        }

        System.out.println(sum);
    }
}
