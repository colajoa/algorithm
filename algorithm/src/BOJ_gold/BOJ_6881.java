package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_6881 {
    static int R, C;
    static int[][] map;
    static int[] num = new int[3];
    static boolean[][] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static boolean flag = false;
    static Queue<Point> q = new ArrayDeque<>();

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void perm(int depth) {
        if (depth == 3) {
            visited = new boolean[R][C];

            for (int c = 0; c < C && !flag; c++) {
                for (int n = 0; n < 3 && !flag; n++) {
                    if (map[0][c] == num[n]) {
                        visited[0][c] = true;
                        q.add(new Point(0, c));
                        flag = bfs();
                        visited[0][c] = false;
                        q.clear();
                    }
                }
            }
            return;
        }

        for (int d = 0; d < 10 && !flag; d++) {
            num[depth] = d;
            perm(depth + 1);
        }
    }

    static boolean bfs() {
        while (!q.isEmpty()) {
            Point now = q.poll();
            if (now.r == R - 1) {
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {
                    for (int n = 0; n < 3; n++) {
                        if (map[nr][nc] == num[n]) {
                            visited[nr][nc] = true;
                            q.add(new Point(nr, nc));
                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        C = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());

        map = new int[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        perm(0);

        if (!flag) {
            System.out.println("-1 -1 -1");
        } else {
            System.out.println(num[0] + " " + num[1] + " " + num[2]);
        }
    }
}
