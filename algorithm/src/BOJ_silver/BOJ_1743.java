package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_1743 {
    static int N, M, K;
    static int ans = -1;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static boolean[][] ground;
    static Queue<Point> q = new ArrayDeque<>();
    static boolean[][] visited;

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void bfs(int r, int c) {
        q.add(new Point(r, c));
        visited[r][c] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && ground[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                    cnt += 1;
                }
            }
        }

        ans = cnt > ans ? cnt : ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        ground = new boolean[N][M];
        visited = new boolean[N][M];

        for (int k = 0; k < K; k++) {
            token = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(token.nextToken()) - 1;
            int m = Integer.parseInt(token.nextToken()) - 1;
            ground[n][m] = true;
        }

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (ground[n][m] && !visited[n][m]) {
                    bfs(n, m);
                }
            }
        }

        System.out.println(ans);
    }
}