package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_11123 {
    static int H, W;
    static char[][] map;
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

    static void bfs() {

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == '#' && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int ans = 0;
            token = new StringTokenizer(br.readLine());
            H = Integer.parseInt(token.nextToken());
            W = Integer.parseInt(token.nextToken());

            map = new char[H][W];
            visited = new boolean[H][W];
            
            for (int r = 0; r < H; r++) {
                String str = br.readLine();
                for (int c = 0; c < W; c++) {
                    map[r][c] = str.charAt(c);
                }
            }

            for (int r = 0; r < H; r++) {
                for (int c = 0; c < W; c++) {
                    if (map[r][c] == '#' && !visited[r][c]) {
                        visited[r][c] = true;
                        q.add(new Point(r, c));
                        bfs();
                        ans += 1;
                    }
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
