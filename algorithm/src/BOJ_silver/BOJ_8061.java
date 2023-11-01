package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_8061 {
    static int N, M;
    static int[][] map;

    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Queue<Point> q = new ArrayDeque<>();
    static boolean[][] visited;

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int bfs() {
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                    map[nr][nc] = map[now.r][now.c] + 1;
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }
            }
        }
        return 0;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = str.charAt(c) - '0';
                if (map[r][c] == 1) {
                    map[r][c] = 0;
                    visited[r][c] = true;
                    q.add(new Point(r, c));
                }
            }
        }

        bfs();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                sb.append(map[r][c]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
