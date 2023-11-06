package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_26549 {
    static int R, C, spaces, sec;
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
            spaces += 1;
            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] == '.') {
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
            token = new StringTokenizer(br.readLine());
            R = Integer.parseInt(token.nextToken());
            C = Integer.parseInt(token.nextToken());

            map = new char[R][C];
            visited = new boolean[R][C];

            for (int r = 0; r < R; r++) {
                String str = br.readLine();
                for (int c = 0; c < C; c++) {
                    map[r][c] = str.charAt(c);
                }
            }

            sec = 0;
            spaces = 0;
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (map[r][c] == '.' && !visited[r][c]) {
                        visited[r][c] = true;
                        q.add(new Point(r, c));
                        bfs();
                        sec += 1;
                    }
                }
            }

            sb.append(sec).append(" ");
            if (sec > 1 || sec == 0) {
                sb.append("sections, ");
            } else {
                sb.append("section, ");
            }

            sb.append(spaces).append(" ");
            if (spaces > 1 || spaces == 0) {
                sb.append("spaces");
            } else {
                sb.append("space");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
