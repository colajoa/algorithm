package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_13565 {
    static int M, N;
    static int[][] map;
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

    static boolean bfs() {

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.r == M - 1) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == 0) {
                    q.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];
        for (int r = 0; r < M; r++) {
            String str = br.readLine();
            for (int c = 0; c < N; c++) {
                map[r][c] = str.charAt(c) - '0';
            }
        }

        for (int c = 0; c < N; c++) {
            if (map[0][c] == 0 && !visited[0][c]) {
                q.add(new Point(0, c));
                visited[0][c] = true;
            }
        }

        if (bfs()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
