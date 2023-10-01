package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_13700 {
    static int N, S, D, K;
    static int[] step = new int[2];
    static int[] map;
    static boolean[] visited;

    static class Point {
        int point, cnt;

        public Point(int point, int cnt) {
            this.point = point;
            this.cnt = cnt;
        }
    }

    static int bfs() {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(S, 0));
        visited[S] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.point == D) {
                return now.cnt;
            }
            for (int d = 0; d < 2; d++) {
                int next = now.point + step[d];

                if (next > 0 && next <= N && !visited[next] && map[next] != -1) {
                    visited[next] = true;
                    q.add(new Point(next, now.cnt + 1));
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        S = Integer.parseInt(token.nextToken());
        D = Integer.parseInt(token.nextToken());
        step[0] = Integer.parseInt(token.nextToken());
        step[1] = -Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        map = new int[N + 1];
        visited = new boolean[N + 1];

        map[D] = 1;

        if (K > 0) {
            token = new StringTokenizer(br.readLine());
        }

        for (int k = 0; k < K; k++) {
            map[Integer.parseInt(token.nextToken())] = -1;
        }

        int cnt = bfs();

        if (cnt == 0) {
            System.out.println("BUG FOUND");
        } else {
            System.out.println(cnt);
        }

    }
}
