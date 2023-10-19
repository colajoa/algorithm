package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_29634 {
    static int N, M, max = -1;
    static char[][] map;
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

    static int bfs() {
        int cnt = 1;
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] == '.') {
                    visited[nr][nc] = true;
                    cnt += 1;
                    q.add(new Point(nr, nc));
                }
            }

        }
        return cnt;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == '.' && !visited[r][c]) {
                    visited[r][c] = true;
                    q.add(new Point(r, c));
                    int cnt = bfs();
                    if (max < cnt) {
                        max = cnt;
                    }
                }
            }
        }

        System.out.println(max);
    }
}
