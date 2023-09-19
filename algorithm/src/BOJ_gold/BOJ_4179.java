package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_4179 {
    static int R, C, sr, sc, ans = 0;
    static char[][] map;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Queue<Point> q = new ArrayDeque<>();
    static boolean[][] visited;

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static boolean bfs() {

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (map[now.r][now.c] == 'F') {
                for (int d = 0; d < 4; d++) {
                    int nr = now.r + dr[d];
                    int nc = now.c + dc[d];

                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] != '#') {
                        visited[nr][nc] = true;
                        map[nr][nc] = 'F';
                        q.add(new Point(nr, nc, now.cnt + 1));
                    }
                }
            } else if (map[now.r][now.c] == 'J') {
                if (now.r == 0 || now.r == R - 1 || now.c == 0 || now.c == C - 1) {
                    ans = now.cnt + 1;
                    return true;
                }
                for (int d = 0; d < 4; d++) {
                    int nr = now.r + dr[d];
                    int nc = now.c + dc[d];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] == '.') {
                        visited[nr][nc] = true;
                        map[nr][nc] = 'J';
                        map[now.r][now.c] = '.';
                        q.add(new Point(nr, nc, now.cnt + 1));
                    }
                }
            }
        }
        return false;
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
                if (map[r][c] == 'F') {
                    visited[r][c] = true;
                    q.add(new Point(r, c, 0));
                } else if (map[r][c] == 'J') {
                    sr = r;
                    sc = c;
                    visited[r][c] = true;
                }
            }
        }
        q.add(new Point(sr, sc, 0));

        if (!bfs()) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(ans);
        }
    }
}
