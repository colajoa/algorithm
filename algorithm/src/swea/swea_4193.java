package swea;

import java.io.*;
import java.util.*;

public class swea_4193 {
    static int N, pool[][], endR, endC;
    static int dr[] = { -1, 0, 1, 0 };
    static int dc[] = { 0, 1, 0, -1 };

    static class Point {
        int r, c, time;

        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static int bfs(int sr, int sc) {
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        q.add(new Point(sr, sc, 0));
        visited[sr][sc] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr == endR && nc == endC)
                    return now.time + 1;
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && pool[nr][nc] != 1) {
                    if (pool[nr][nc] == 2) {
                        if (now.time % 3 == 2) {
                            visited[nr][nc] = true;
                            q.add(new Point(nr, nc, now.time));
                        } else {
                            q.add(new Point(now.r, now.c, now.time + 1));
                        }
                    } else {
                        visited[nr][nc] = true;
                        q.add(new Point(nr, nc, now.time + 1));
                    }

                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            pool = new int[N][N];

            for (int r = 0; r < N; r++) {
                token = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    pool[r][c] = Integer.parseInt(token.nextToken());
                }
            }

            int startR, startC;

            token = new StringTokenizer(br.readLine());
            startR = Integer.parseInt(token.nextToken());
            startC = Integer.parseInt(token.nextToken());

            token = new StringTokenizer(br.readLine());
            endR = Integer.parseInt(token.nextToken());
            endC = Integer.parseInt(token.nextToken());

            int ans = bfs(startR, startC);

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
