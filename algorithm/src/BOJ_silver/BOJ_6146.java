package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_6146 {
    static int X, Y, N;
    static int[][] map = new int[1001][1001];
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int bfs() {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(500, 500, 0));
        map[500][500] = -1;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.r == X && now.c == Y) {
                return now.cnt;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nc < 1001 && nc >= 0 && nc < 1001 && map[nr][nc] != -1) {
                    map[nr][nc] = -1;
                    q.add(new Point(nr, nc, now.cnt + 1));
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        X = Integer.parseInt(token.nextToken()) + 500;
        Y = Integer.parseInt(token.nextToken()) + 500;
        N = Integer.parseInt(token.nextToken());

        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(token.nextToken()) + 500;
            int B = Integer.parseInt(token.nextToken()) + 500;

            map[A][B] = -1;
        }

        System.out.println(bfs());
    }
}
