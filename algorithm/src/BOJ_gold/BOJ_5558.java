package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_5558 {
    static int H, W, N, sr, sc, time = 0;
    static char[][] map;
    static Point[] cheese;
    static boolean[][] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static Queue<Point> q = new ArrayDeque<>();

    static class Point {
        int r, c, cnt;

        public Point() {
        }

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static void bfs(int size) {
        while (!q.isEmpty()) {
            Point now = q.poll();

            if (map[now.r][now.c] - '0' == size) {
                map[now.r][now.c] = '.';
                sr = now.r;
                sc = now.c;
                time += now.cnt;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < H && nc >= 0 && nc < W && !visited[nr][nc] && map[nr][nc] != 'X') {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, now.cnt + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        H = Integer.parseInt(token.nextToken());
        W = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());

        map = new char[H][W];
        cheese = new Point[N + 1];

        for (int n = 1; n < N + 1; n++) {
            cheese[n] = new Point();
        }

        for (int r = 0; r < H; r++) {
            String str = br.readLine();
            for (int c = 0; c < W; c++) {
                map[r][c] = str.charAt(c);
                if (map[r][c] == 'S') {
                    sr = r;
                    sc = c;
                }
                if (map[r][c] - '0' > 0 && map[r][c] - '0' < 10) {
                    cheese[map[r][c] - '0'].r = r;
                    cheese[map[r][c] - '0'].c = c;
                }
            }
        }

        for (int n = 1; n < N + 1; n++) {
            visited = new boolean[H][W];
            visited[sr][sc] = true;
            q.add(new Point(sr, sc, 0));
            bfs(n);
            q.clear();
        }

        System.out.println(time);
    }
}
