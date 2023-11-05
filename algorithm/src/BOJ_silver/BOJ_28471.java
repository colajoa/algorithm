package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_28471 {
    static int N;
    static long cnt = 0;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = { -1, -1, -1, 0, 1, 1, 0 };
    static int[] dc = { -1, 0, 1, 1, 1, -1, -1 };
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

            if (map[now.r][now.c] == '.') {
                cnt += 1;
            }

            for (int d = 0; d < 7; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] != '#') {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < N; c++) {
                map[r][c] = str.charAt(c);
                if (map[r][c] == 'F') {
                    visited[r][c] = true;
                    q.add(new Point(r, c));
                }
            }
        }

        bfs();

        System.out.println(cnt);
    }
}
