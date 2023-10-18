package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_4993 {
    static int W, H, cnt;
    static char[][] map;
    static boolean[][] visited;
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

    static void bfs() {
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < H && nc >= 0 && nc < W && !visited[nr][nc] && map[nr][nc] == '.') {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                    cnt += 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while ((W = Integer.parseInt(token.nextToken())) != 0 &&
                (H = Integer.parseInt(token.nextToken())) != 0) {
            map = new char[H][W];
            visited = new boolean[H][W];

            for (int r = 0; r < H; r++) {
                String str = br.readLine();
                for (int c = 0; c < W; c++) {
                    map[r][c] = str.charAt(c);
                    if (map[r][c] == '@') {
                        visited[r][c] = true;
                        q.add(new Point(r, c));
                    }
                }
            }
            cnt = 1;
            bfs();
            sb.append(cnt).append("\n");
            token = new StringTokenizer(br.readLine());
        }

        System.out.println(sb);
    }
}
