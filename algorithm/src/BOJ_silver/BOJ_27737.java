package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_27737 {
    static int N, M, K;
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

    static int bfs() {
        int cnt = 1;
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == 0) {
                    cnt += 1;
                    visited[nr][nc] = true;
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
        K = Integer.parseInt(token.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        boolean flag = false;
        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c] && map[r][c] == 0) {
                    flag = true;
                    visited[r][c] = true;
                    q.add(new Point(r, c));
                    int cnt = bfs();

                    if (cnt % K == 0) {
                        M -= cnt / K;
                    } else {
                        M -= (cnt / K) + 1;
                    }
                }
            }
        }

        if (M < 0 || !flag) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println("POSSIBLE");
            System.out.println(M);
        }

    }
}
