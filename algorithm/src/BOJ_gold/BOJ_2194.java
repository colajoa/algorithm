package BOJ_gold;

import java.io.*;
import java.util.*;

// 배열 크기 생각하면서 풀기
public class BOJ_2194 {
    static int N, M, A, B, K, sr, sc, er, ec;
    static int[][] map;
    static boolean[][] visited;
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
        visited[sr][sc] = true;
        q.add(new Point(sr, sc, 0));

        while (!q.isEmpty()) {
            Point now = q.poll();
            if (now.r == er && now.c == ec) {
                return now.cnt;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr < 1 || nr > N || nc < 1 || nc > M)
                    continue;
                if (nr + (A - 1) < 1 || nr + (A - 1) > N || nc + (B - 1) < 1 || nc + (B - 1) > M)
                    continue;
                boolean flag = true;
                for (int r = 0; r < A && flag; r++) {
                    for (int c = 0; c < B && flag; c++) {
                        if (map[nr + r][nc + c] == -1) {
                            flag = false;
                            break;
                        }
                    }
                }

                if (!flag) {
                    continue;
                } else if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc, now.cnt + 1));
                }

            }

        }
        return -1;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        A = Integer.parseInt(token.nextToken());
        B = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        map = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        for (int k = 0; k < K; k++) {
            token = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(token.nextToken());
            int c = Integer.parseInt(token.nextToken());

            map[r][c] = -1;
        }

        token = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(token.nextToken());
        sc = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        er = Integer.parseInt(token.nextToken());
        ec = Integer.parseInt(token.nextToken());

        System.out.println(bfs());
    }
}
