package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_17086 {
    static int N, M, max = -1;
    static int[][] map;
    static int[][] ans;
    static boolean[][] visited;
    static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
    static Queue<Point> q = new ArrayDeque<>();

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Point now = q.poll();
            for (int d = 0; d < 8; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                    q.add(new Point(nr, nc));
                    ans[nr][nc] = ans[now.r][now.c] + 1;
                    visited[nr][nc] = true;
                    if (max < ans[nr][nc])
                        max = ans[nr][nc];
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        ans = new int[N][M];

        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(token.nextToken());
                if (map[n][m] == 1) {
                    visited[n][m] = true;
                    q.add(new Point(n, m));
                }
            }
        }

        bfs();

        System.out.println(max);
    }
}
