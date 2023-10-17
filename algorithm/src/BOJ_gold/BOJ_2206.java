package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_2206 {
    static int N, M;
    static int[][] map;
    static int ans = Integer.MAX_VALUE;
    static boolean[][][] visited;
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

    static Queue<Point> q = new ArrayDeque<>();

    static int bfs() {
        q.add(new Point(0, 0, 1, false));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.r == N - 1 && now.c == M - 1) {
                return now.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (map[nr][nc] == 0) {
                        if (!now.flag && !visited[0][nr][nc]) {
                            visited[0][nr][nc] = true;
                            q.add(new Point(nr, nc, now.cnt + 1, false));
                        } else if (now.flag && !visited[1][nr][nc]) {
                            visited[1][nr][nc] = true;
                            q.add(new Point(nr, nc, now.cnt + 1, true));
                        }
                    } else if (map[nr][nc] == 1) {
                        if (!now.flag) {
                            visited[1][nr][nc] = true;
                            q.add(new Point(nr, nc, now.cnt + 1, true));
                        }
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

        map = new int[N][M];
        visited = new boolean[2][N][M];

        for (int n = 0; n < N; n++) {
            String str = br.readLine();
            for (int m = 0; m < M; m++) {
                map[n][m] = str.charAt(m) - '0';
            }
        }

        System.out.println(bfs());
    }
}
