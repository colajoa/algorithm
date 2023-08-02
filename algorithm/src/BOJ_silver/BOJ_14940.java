package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_14940 {
    static int N, M;
    static int[][] map, ans;
    static boolean[][] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;

        }
    }

    static void bfs(int r, int c) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(r, c));
        ans[r][c] = 0;
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();
            int nr = 0;
            int nc = 0;
            for (int i = 0; i < 4; i++) {
                nr = now.r + dr[i];
                nc = now.c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] == 1) {
                    ans[nr][nc] = ans[now.r][now.c] + 1;
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
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

        map = ans = new int[N][M];
        visited = new boolean[N][M];

        int r = 0;
        int c = 0;
        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(token.nextToken());
                if (map[n][m] == 2) {
                    r = n;
                    c = m;
                }
            }
        }

        bfs(r, c);

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (map[n][m] == 1 && !visited[n][m]) {
                    ans[n][m] = -1;
                }
                sb.append(ans[n][m]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
