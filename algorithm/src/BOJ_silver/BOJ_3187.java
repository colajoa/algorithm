package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_3187 {
    static int R, C, V, K;
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

    static void bfs(char ch) {
        int v = 0;
        int k = 0;
        if (ch == 'v') {
            v += 1;
        } else if (ch == 'k') {
            k += 1;
        }
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] != '#') {
                    if (map[nr][nc] == 'v') {
                        v += 1;
                    } else if (map[nr][nc] == 'k') {
                        k += 1;
                    }
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }
            }
        }

        if (k > v) {
            V -= v;
        } else {
            K -= k;
        }
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

                if (map[r][c] == 'v') {
                    V += 1;
                } else if (map[r][c] == 'k') {
                    K += 1;
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (!visited[r][c] && map[r][c] != '#') {
                    visited[r][c] = true;
                    q.add(new Point(r, c));
                    bfs(map[r][c]);
                }
            }
        }

        System.out.println(K + " " + V);
    }
}
