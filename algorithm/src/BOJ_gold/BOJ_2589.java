package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_2589 {
    static int R, C, max = -1;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
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
        int cnt = 0;
        while (!q.isEmpty()) {
            Point now = q.poll();
            cnt = now.cnt;

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] == 'L') {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, now.cnt + 1));
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        map = new char[R][C];

        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 'L') {
                    visited = new boolean[R][C];
                    visited[r][c] = true;
                    q.add(new Point(r, c, 0));
                    int cnt = bfs();
                    max = cnt > max ? cnt : max;
                }
            }
        }

        System.out.println(max);
    }
}
