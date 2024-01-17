package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_14442 {
    static int N, M, K;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Queue<Point> q = new ArrayDeque<>();

    static class Point {
        int r, c, cnt, broke;

        public Point(int r, int c, int cnt, int broke) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.broke = broke;
        }
    }

    static int bfs() {
        visited[0][0][0] = true;
        q.add(new Point(0, 0, 1, 0));

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.r == N - 1 && now.c == M - 1) {
                return now.cnt;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (map[nr][nc] == 0 && !visited[now.broke][nr][nc]) {
                        visited[now.broke][nr][nc] = true;
                        q.add(new Point(nr, nc, now.cnt + 1, now.broke));
                    } else if (map[nr][nc] == 1 && now.broke != K && !visited[now.broke + 1][nr][nc]) {
                        visited[now.broke + 1][nr][nc] = true;
                        q.add(new Point(nr, nc, now.cnt + 1, now.broke + 1));
                    }
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
        K = Integer.parseInt(token.nextToken());

        map = new int[N][M];
        visited = new boolean[K + 1][N][M];

        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < M; c++) {
                map[r][c] = str.charAt(c) - '0';
            }
        }

        System.out.println(bfs());
    }
}
