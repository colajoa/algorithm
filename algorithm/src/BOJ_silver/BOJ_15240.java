package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_15240 {
    static int R, C, sr, sc, K, org;
    static int[][] map;
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

    static void dfs(int r, int c) {
        map[r][c] = K;
        visited[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] == org) {
                dfs(nr, nc);
            }
        }
    }

    static void bfs() {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(sr, sc));
        visited[sr][sc] = true;
        map[sr][sc] = K;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] == org) {
                    map[nr][nc] = K;
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

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        map = new int[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c) - '0';
            }
        }

        token = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(token.nextToken());
        sc = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        org = map[sr][sc];

        dfs(sr, sc);

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                sb.append(map[r][c]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
