package woojos;

import java.io.*;
import java.util.*;

public class BOJ_16174 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = { 1, 0 };
    static int[] dc = { 0, 1 };

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void bfs() {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point jelly = q.poll();
            int dis = map[jelly.r][jelly.c];
            if (dis == -1) {
                System.out.println("HaruHaru");
                return;
            }
            for (int i = 0; i < 2; i++) {
                int nr = jelly.r + (dis * dr[i]);
                int nc = jelly.c + (dis * dc[i]);

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }
            }
        }
        System.out.println("Hing");
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine(), " ");
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }
        bfs();
    }
}