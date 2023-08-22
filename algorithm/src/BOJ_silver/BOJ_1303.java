package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_1303 {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static Queue<Point> q = new ArrayDeque<>();
    static int white = 0, blue = 0;
    static int cnt;

    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void bfs(int r, int c) {
        cnt = 1;
        visited[r][c] = true;
        q.add(new Point(r, c));

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] == map[r][c]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                    cnt += 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new char[M][N];
        visited = new boolean[M][N];

        for (int m = 0; m < M; m++) {
            String str = br.readLine();
            for (int n = 0; n < N; n++) {
                map[m][n] = str.charAt(n);
            }
        }

        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                if (!visited[m][n]) {
                    bfs(m, n);
                    int ans = cnt * cnt;
                    if (map[m][n] == 'W') {
                        white += ans;
                    } else {
                        blue += ans;
                    }
                }

            }
        }

        System.out.println(white + " " + blue);
    }
}
