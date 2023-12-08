package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_6798 {
    static int sr, sc, er, ec;
    static boolean[][] visited = new boolean[8][8];
    static Queue<Point> q = new ArrayDeque<>();
    static int[] dr = { -2, -2, -1, -1, 1, 1, 2, 2 };
    static int[] dc = { -1, 1, -2, 2, -2, 2, -1, 1 };

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int bfs() {
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.r == er && now.c == ec) {
                return now.cnt;
            }

            for (int d = 0; d < 8; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < 8 && nc >= 0 && nc < 8 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, now.cnt + 1));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        sc = 8 - Integer.parseInt(token.nextToken());
        sr = 8 - Integer.parseInt(token.nextToken());
        q.add(new Point(sr, sc, 0));

        token = new StringTokenizer(br.readLine());
        ec = 8 - Integer.parseInt(token.nextToken());
        er = 8 - Integer.parseInt(token.nextToken());

        System.out.println(bfs());
    }
}
