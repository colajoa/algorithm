package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_7562 {
    static int T, N, er, ec;
    static int[][] map;
    static int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
    static int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };
    static Queue<Point> q;

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void bfs(int r, int c) {
        map[r][c] = 1;
        q.add(new Point(r, c));

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.r == er && now.c == ec) {
                return;
            }
            for (int d = 0; d < 8; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 0) {
                    q.add(new Point(nr, nc));
                    map[nr][nc] = map[now.r][now.c] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        q = new ArrayDeque<>();
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];

            token = new StringTokenizer(br.readLine());

            int sr = Integer.parseInt(token.nextToken());
            int sc = Integer.parseInt(token.nextToken());

            token = new StringTokenizer(br.readLine());

            er = Integer.parseInt(token.nextToken());
            ec = Integer.parseInt(token.nextToken());

            bfs(sr, sc);
            sb.append(map[er][ec] - 1).append("\n");
            q.clear();
        }

        System.out.println(sb);
    }
}
