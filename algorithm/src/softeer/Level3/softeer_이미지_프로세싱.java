package softeer.Level3;

import java.io.*;
import java.util.*;

public class softeer_이미지_프로세싱 {
    static int H, W, color;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Queue<Point> q = new ArrayDeque<>();

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void bfs(int org) {
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < H && nc >= 0 && nc < W && !visited[nr][nc] && map[nr][nc] == org) {
                    visited[nr][nc] = true;
                    map[nr][nc] = color;
                    q.add(new Point(nr, nc));
                }
            }
        }
    }

    static void print() {
        StringBuilder sb = new StringBuilder();

        for (int r = 0; r < H - 1; r++) {
            for (int c = 0; c < W - 1; c++) {
                sb.append(map[r][c]).append(" ");
            }
            sb.append(map[r][W - 1]);
            sb.append("\n");
        }

        for (int c = 0; c < W - 1; c++) {
            sb.append(map[H - 1][c]).append(" ");
        }
        sb.append(map[H - 1][W - 1]);
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        H = Integer.parseInt(token.nextToken());
        W = Integer.parseInt(token.nextToken());

        map = new int[H][W];
        for (int r = 0; r < H; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < W; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        int Q = Integer.parseInt(br.readLine());

        for (int n = 0; n < Q; n++) {
            token = new StringTokenizer(br.readLine());
            visited = new boolean[H][W];

            int r = Integer.parseInt(token.nextToken()) - 1;
            int c = Integer.parseInt(token.nextToken()) - 1;
            color = Integer.parseInt(token.nextToken());

            visited[r][c] = true;
            int org = map[r][c];
            map[r][c] = color;
            q.add(new Point(r, c));
            bfs(org);
        }

        print();
    }
}
