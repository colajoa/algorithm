package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_21938 {
    static int N, M, T, ans;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
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

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] >= T) {
                    map[nr][nc] = -1;
                    q.add(new Point(nr, nc));
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
        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                int R = Integer.parseInt(token.nextToken());
                int G = Integer.parseInt(token.nextToken());
                int B = Integer.parseInt(token.nextToken());

                map[n][m] = (R + G + B) / 3;
            }
        }

        T = Integer.parseInt(br.readLine());

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] >= T) {
                    ans += 1;
                    map[r][c] = -1;
                    q.add(new Point(r, c));
                    bfs();
                }
            }
        }

        System.out.println(ans);
    }
}
