package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2583 {
    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;
    static PriorityQueue<Integer> ans = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
    static Queue<Point> q = new ArrayDeque<>();
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void bfs(int r, int c) {
        q.add(new Point(r, c));
        visited[r][c] = true;
        int sum = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                    sum += 1;
                }
            }
        }
        ans.add(sum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int k = 0; k < K; k++) {
            token = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(token.nextToken());
            int y1 = Integer.parseInt(token.nextToken());
            int x2 = Integer.parseInt(token.nextToken());
            int y2 = Integer.parseInt(token.nextToken());

            for (int m = x1; m < x2; m++) {
                for (int n = y1; n < y2; n++) {
                    map[n][m] = 1;
                }
            }
        }

        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                if (map[m][n] == 0 && !visited[m][n]) {
                    bfs(m, n);
                }
            }
        }

        sb.append(ans.size()).append("\n");
        while (!ans.isEmpty()) {
            sb.append(ans.poll()).append(" ");
        }

        System.out.println(sb);
    }
}
