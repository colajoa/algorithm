package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_5011 {
    static int N, MAX = Integer.MAX_VALUE;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Queue<Point> q = new ArrayDeque<>();
    static char[][] map;
    static boolean[][] visited;

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static boolean bfs() {
        visited[0][0] = true;
        q.add(new Point(0, 0));

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.r == N - 1 && now.c == N - 1) {
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == '.') {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        long[][] dp = new long[N][N];

        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < N; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        dp[0][0] = 1;
        for (int c = 1; c < N; c++) {
            if (map[0][c] == '#') {
                break;
            }
            dp[0][c] = 1;
        }

        for (int r = 1; r < N; r++) {
            if (map[r][0] == '#') {
                break;
            }
            dp[r][0] = 1;
        }

        for (int r = 1; r < N; r++) {
            for (int c = 1; c < N; c++) {
                if (map[r][c] == '#')
                    continue;
                dp[r][c] = (dp[r - 1][c] + dp[r][c - 1]) % MAX;
            }
        }

        if (dp[N - 1][N - 1] == 0) {
            if (bfs()) {
                System.out.println("THE GAME IS A LIE");
            } else {
                System.out.println("INCONCEIVABLE");
            }
        } else {
            System.out.println(dp[N - 1][N - 1]);
        }
    }
}
