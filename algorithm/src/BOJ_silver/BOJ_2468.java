package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2468 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int max = -1;
    static int ans = -1;
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

    static Queue<Point> q = new ArrayDeque<>();

    static void search(int r, int c, int m) {
        visited[r][c] = true;
        q.add(new Point(r, c));

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] > m) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
                if (map[r][c] > max) {
                    max = map[r][c];
                }
            }
        }

        for (int m = 0; m < max; m++) {
            cnt = 0;
            visited = new boolean[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!visited[r][c] && map[r][c] > m) {
                        search(r, c, m);
                        cnt += 1;
                    }
                }
            }

            if (ans < cnt) {
                ans = cnt;
            }
        }

        System.out.println(ans);
    }
}
