package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_11607 {
    static int R, C;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Point> q = new ArrayDeque<>();
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

    static String bfs() {
        visited[0][0] = true;
        q.add(new Point(0, 0, 0));

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.r == R - 1 && now.c == C - 1) {
                return now.cnt + "";
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + (dr[d] * map[now.r][now.c]);
                int nc = now.c + (dc[d] * map[now.r][now.c]);

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, now.cnt + 1));
                }
            }

        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

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

        System.out.println(bfs());
    }
}
