package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_16948 {
    static int N, r1, c1, r2, c2;
    static int[][] map;
    static int[] dr = { -2, -2, 0, 0, 2, 2 };
    static int[] dc = { -1, 1, -2, 2, -1, 1 };
    static Queue<Point> q = new ArrayDeque<>();

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int bfs() {
        map[r1][c1] = -1;
        q.add(new Point(r1, c1, 0));

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.r == r2 && now.c == c2) {
                return now.cnt;
            }

            for (int d = 0; d < 6; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 0) {
                    map[nr][nc] = -1;
                    q.add(new Point(nr, nc, now.cnt + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());

        token = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(token.nextToken());
        c1 = Integer.parseInt(token.nextToken());
        r2 = Integer.parseInt(token.nextToken());
        c2 = Integer.parseInt(token.nextToken());

        map = new int[N][N];

        System.out.println(bfs());
    }
}
