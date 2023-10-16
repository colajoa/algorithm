package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_14923 {
    static int N, M, Hx, Hy, Ex, Ey;
    static int[][] map;
    static boolean[][][] visited;
    static int ans = -1;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static class Point {
        int r, c, cnt;
        boolean flag;

        public Point(int r, int c, int cnt, boolean flag) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.flag = flag;
        }
    }

    static void bfs() {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(Hx, Hy, 0, false));
        visited[0][Hx][Hy] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.r == Ex && now.c == Ey) {
                ans = now.cnt;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 1 && nr <= N && nc >= 1 && nc <= M) {
                    if (map[nr][nc] == 0) {
                        if (!now.flag && !visited[0][nr][nc]) {
                            q.add(new Point(nr, nc, now.cnt + 1, now.flag));
                            visited[0][nr][nc] = true;
                        } else if (now.flag && !visited[1][nr][nc]) {
                            q.add(new Point(nr, nc, now.cnt + 1, now.flag));
                            visited[1][nr][nc] = true;
                        }
                    } else if (map[nr][nc] == 1) {
                        if (!now.flag) {
                            q.add(new Point(nr, nc, now.cnt + 1, true));
                            visited[1][nr][nc] = true;
                        }
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[2][N + 1][M + 1];

        token = new StringTokenizer(br.readLine());
        Hx = Integer.parseInt(token.nextToken());
        Hy = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        Ex = Integer.parseInt(token.nextToken());
        Ey = Integer.parseInt(token.nextToken());

        for (int n = 1; n < N + 1; n++) {
            token = new StringTokenizer(br.readLine());
            for (int m = 1; m < M + 1; m++) {
                map[n][m] = Integer.parseInt(token.nextToken());
            }
        }

        bfs();

        System.out.println(ans);
    }
}
