package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_1261_우선순위_큐 {
    static int N, M, ans = 0;
    static int[][] map;
    static boolean[][] visited;
    static PriorityQueue<Point> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cnt, o2.cnt));
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

    static void bfs() {
        visited[0][0] = true;
        q.add(new Point(0, 0, 0));

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.r == N - 1 && now.c == M - 1) {
                ans = now.cnt;
                return;
            }
            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    if (map[nr][nc] == 0) {
                        q.add(new Point(nr, nc, now.cnt));
                    } else {
                        q.add(new Point(nr, nc, now.cnt + 1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int n = 0; n < N; n++) {
            String str = br.readLine();
            for (int m = 0; m < M; m++) {
                map[n][m] = str.charAt(m) - '0';
            }
        }

        bfs();

        System.out.println(ans);
    }
}
