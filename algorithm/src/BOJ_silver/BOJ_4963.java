package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_4963 {
    static int W, H, ans;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
    static Queue<Point> q = new ArrayDeque<>();

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 8; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr >= 0 && nr < H && nc >= 0 && nc < W && !visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while ((W = Integer.parseInt(token.nextToken())) != 0 && (H = Integer.parseInt(token.nextToken())) != 0) {

            map = new int[H][W];
            visited = new boolean[H][W];
            for (int r = 0; r < H; r++) {
                token = new StringTokenizer(br.readLine());
                for (int c = 0; c < W; c++) {
                    map[r][c] = Integer.parseInt(token.nextToken());
                }
            }

            ans = 0;
            for (int r = 0; r < H; r++) {
                for (int c = 0; c < W; c++) {
                    if (map[r][c] == 1 && !visited[r][c]) {
                        ans += 1;
                        visited[r][c] = true;
                        q.add(new Point(r, c));
                        bfs();
                    }
                }
            }
            sb.append(ans).append("\n");
            token = new StringTokenizer(br.readLine());
        }
        System.out.println(sb);
    }
}
