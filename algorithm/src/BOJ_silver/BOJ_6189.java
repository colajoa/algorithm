package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_6189 {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Queue<Point> q = new ArrayDeque<>();

    static class Point {
        int r, c;
        long cnt;

        public Point(int r, int c, long cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static long bfs() {
        while (!q.isEmpty()) {
            Point now = q.poll();

            if (map[now.r][now.c] == 'C') {
                return now.cnt;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] != '*') {
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

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
                if (map[r][c] == 'B') {
                    visited[r][c] = true;
                    q.add(new Point(r, c, 0));
                }
            }
        }

        System.out.println(bfs());
    }
}
