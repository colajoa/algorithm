package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_16509 {
    static int sr, sc, er, ec;
    static int[][] map = new int[10][9];
    static boolean[][] visited = new boolean[10][9];
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int bfs() {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(sr, sc, 0));
        visited[sr][sc] = true;
        while (!q.isEmpty()) {
            Point now = q.poll();

            if (map[now.r][now.c] == -1) {
                return now.cnt;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (path(nr, nc)) {
                    if (d % 2 == 0) {
                        nr += dr[d];

                        if (path(nr, nc - 1) && map[nr][nc - 1] == 0) {
                            nr += dr[d];
                            if (path(nr, nc - 2) && !visited[nr][nc - 2]) {
                                visited[nr][nc - 2] = true;
                                q.add(new Point(nr, nc - 2, now.cnt + 1));
                            }
                            nr -= dr[d];
                        }
                        if (path(nr, nc + 1) && map[nr][nc + 1] == 0) {
                            nr += dr[d];
                            if (path(nr, nc + 2) && !visited[nr][nc + 2]) {
                                visited[nr][nc + 2] = true;
                                q.add(new Point(nr, nc + 2, now.cnt + 1));
                            }
                            nr -= dr[d];
                        }

                    } else if (d % 2 == 1) {
                        nc += dc[d];
                        if (path(nr - 1, nc) && map[nr - 1][nc] == 0) {
                            nc += dc[d];
                            if (path(nr - 2, nc) && !visited[nr - 2][nc]) {
                                visited[nr - 2][nc] = true;
                                q.add(new Point(nr - 2, nc, now.cnt + 1));
                            }
                            nc -= dc[d];
                        }
                        if (path(nr + 1, nc) && map[nr + 1][nc] == 0) {
                            nc += dc[d];
                            if (path(nr + 2, nc) && !visited[nr + 2][nc]) {
                                visited[nr + 2][nc] = true;
                                q.add(new Point(nr + 2, nc, now.cnt + 1));
                            }
                            nc -= dc[d];
                        }

                    }
                }
            }
        }
        return -1;
    }

    static boolean path(int nr, int nc) {
        if (nr >= 0 && nr < 10 && nc >= 0 && nc < 9) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        sr = Integer.parseInt(token.nextToken());
        sc = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());

        er = Integer.parseInt(token.nextToken());
        ec = Integer.parseInt(token.nextToken());

        map[er][ec] = -1;

        System.out.println(bfs());
    }
}
