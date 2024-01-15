package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_1726 {
    static int M, N, sr, sc, sd, er, ec, ed;
    static int[][] map;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static boolean[][][] visited;
    static Queue<Robot> robots = new ArrayDeque<>();

    static class Robot {
        int r, c, dir, cnt;

        public Robot(int r, int c, int dir, int cnt) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cnt = cnt;
        }
    }

    static int bfs() {
        visited[sd][sr][sc] = true;
        robots.add(new Robot(sr, sc, sd, 0));

        while (!robots.isEmpty()) {
            Robot now = robots.poll();
            if (now.r == er && now.c == ec && now.dir == ed) {
                return now.cnt;
            }
            for (int d = 1; d < 4; d++) {
                int nr = now.r + (dr[now.dir] * d);
                int nc = now.c + (dc[now.dir] * d);
                if (nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[now.dir][nr][nc]) {
                    if (map[nr][nc] == 1) {
                        break;
                    }
                    visited[now.dir][nr][nc] = true;
                    robots.add(new Robot(nr, nc, now.dir, now.cnt + 1));
                }
            }
            for (int d = -1; d < 2; d += 2) {
                int nd = (4 + now.dir + d) % 4;

                if (!visited[nd][now.r][now.c]) {
                    visited[nd][now.r][now.c] = true;
                    robots.add(new Robot(now.r, now.c, nd, now.cnt + 1));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());

        map = new int[M][N];
        visited = new boolean[4][M][N];

        for (int r = 0; r < M; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        token = new StringTokenizer(br.readLine());

        sr = Integer.parseInt(token.nextToken()) - 1;
        sc = Integer.parseInt(token.nextToken()) - 1;
        sd = Integer.parseInt(token.nextToken()) - 1;

        if (sd == 0) {
            sd = 1;
        } else if (sd == 1) {
            sd = 3;
        } else if (sd == 3) {
            sd = 0;
        }
        token = new StringTokenizer(br.readLine());

        er = Integer.parseInt(token.nextToken()) - 1;
        ec = Integer.parseInt(token.nextToken()) - 1;
        ed = Integer.parseInt(token.nextToken()) - 1;

        if (ed == 0) {
            ed = 1;
        } else if (ed == 1) {
            ed = 3;
        } else if (ed == 3) {
            ed = 0;
        }

        System.out.println(bfs());
    }
}
