package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_14271 {
    static int N, M, K;
    static char[][] map;
    static boolean[][] visisted;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static Queue<Point> q = new ArrayDeque<>();

    static class Point {
        int r, c, time;

        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static int bfs() {
        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.time == K) {
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < 3050 && nc >= 0 && nc < 3050 && map[nr][nc] != 'o') {
                    map[nr][nc] = 'o';
                    q.add(new Point(nr, nc, now.time + 1));
                }
            }
        }

        int cnt = 0;

        for (int r = 0; r < 3050; r++) {
            for (int c = 0; c < 3050; c++) {
                if (map[r][c] == 'o') {
                    cnt += 1;
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

        map = new char[3050][3050];

        int len = 0;
        for (int r = 1500; r < 1500 + N; r++) {
            len = 0;
            String str = br.readLine();
            for (int c = 1500; c < 1500 + M; c++) {
                map[r][c] = str.charAt(len++);
                if (map[r][c] == 'o') {
                    q.add(new Point(r, c, 0));
                }
            }
        }

        K = Integer.parseInt(br.readLine());
        System.out.println(bfs());
    }
}
