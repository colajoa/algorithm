package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_17836 {
    static int N, M, T, ans;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Queue<Point> q = new ArrayDeque<>();

    static class Point {
        int r, c, cnt;
        boolean getSword;

        public Point(int r, int c, int cnt, boolean getSword) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.getSword = getSword;
        }
    }

    static public int bfs() {
        while (!q.isEmpty()) {
            Point now = q.poll();
            if (now.cnt == T + 1)
                continue;
            if (now.r == N - 1 && now.c == M - 1)
                return now.cnt;

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (!now.getSword) {
                        if (map[nr][nc] == 0 && !visited[0][nr][nc]) {
                            visited[0][nr][nc] = true;
                            q.add(new Point(nr, nc, now.cnt + 1, false));
                        } else if (map[nr][nc] == 2 && !visited[0][nr][nc]) {
                            visited[0][nr][nc] = true;
                            q.add(new Point(nr, nc, now.cnt + 1, true));
                        }

                    } else if (now.getSword) {
                        if (!visited[1][nr][nc]) {
                            visited[1][nr][nc] = true;
                            q.add(new Point(nr, nc, now.cnt + 1, true));
                        }
                    }
                }
            }
        }
        return T + 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        T = Integer.parseInt(token.nextToken());

        map = new int[N][M];
        visited = new boolean[2][N][M];
        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(token.nextToken());
            }
        }

        visited[0][0][0] = true;
        q.add(new Point(0, 0, 0, false));
        ans = bfs();

        if (ans == T + 1) {
            System.out.println("Fail");
        } else {
            System.out.println(ans);
        }

    }
}
