package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_9700 {
    static int N;
    static int[][] map;
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

            for (int d = 0; d < 8; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 1) {
                    map[nr][nc] = 0;
                    q.add(new Point(nr, nc));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        int x = 1;
        while ((str = br.readLine()) != null && !str.isEmpty()) {
            N = Integer.parseInt(str);
            map = new int[N][N];
            int ans = 0;

            for (int r = 0; r < N; r++) {
                String line = br.readLine();
                for (int c = 0; c < N; c++) {
                    map[r][c] = line.charAt(c) - '0';
                }
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == 1) {
                        map[r][c] = 0;
                        q.add(new Point(r, c));
                        bfs();
                        ans += 1;
                    }
                }
            }

            sb.append("Case #").append(x++).append(": ").append(ans).append("\n");
        }

        System.out.println(sb);
    }
}
