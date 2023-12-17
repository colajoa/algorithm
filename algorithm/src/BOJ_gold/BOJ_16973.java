package BOJ_gold;

import java.io.*;
import java.util.*;

// 전체 반복 검사 -> 범위 검사
public class BOJ_16973 {
    static int N, M, sr, sc, fr, fc, H, W, ans = -1;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Queue<Point> q = new ArrayDeque<>();
    static List<Point> walls = new ArrayList<>();

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static boolean check(int r, int c) {
        if (r < 1 || r > N || c < 1 || c > M)
            return false;
        if (r + H - 1 > N || c + W - 1 > M)
            return false;

        for (Point wall : walls) {
            int wr = wall.r;
            int wc = wall.c;

            if (wr >= r && wr <= r + H - 1 && wc >= c && wc <= c + W - 1)
                return false;
        }

        return true;
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.r == fr && now.c == fc) {
                ans = now.cnt;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (check(nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, now.cnt + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        for (int r = 1; r < N + 1; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 1; c < M + 1; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());

                if (map[r][c] == 1)
                    walls.add(new Point(r, c, 0));
            }
        }

        token = new StringTokenizer(br.readLine());

        H = Integer.parseInt(token.nextToken());
        W = Integer.parseInt(token.nextToken());
        sr = Integer.parseInt(token.nextToken());
        sc = Integer.parseInt(token.nextToken());
        fr = Integer.parseInt(token.nextToken());
        fc = Integer.parseInt(token.nextToken());

        q.add(new Point(sr, sc, 0));
        visited[sr][sc] = true;
        bfs();

        System.out.println(ans);
    }
}
