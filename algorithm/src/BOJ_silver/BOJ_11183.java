package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_11183 {
    static int R, C, ans = 0;
    static int[][] map;
    static boolean[][] visited;
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
        Queue<Point> q = new ArrayDeque<>();
        visited[0][0] = true;
        q.add(new Point(0, 0));

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < R + 2 && nc >= 0 && nc < C + 2) {
                    if (!visited[nr][nc] && map[nr][nc] == 0) {
                        visited[nr][nc] = true;
                        q.add(new Point(nr, nc));
                    } else if (map[nr][nc] == 1) {
                        ans += 1;
                    }

                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        map = new int[R + 2][C + 2];
        visited = new boolean[R + 2][C + 2];
        for (int r = 1; r < R + 1; r++) {
            String str = br.readLine();
            for (int c = 1; c < C + 1; c++) {
                map[r][c] = str.charAt(c - 1) - '0';
            }
        }

        bfs();
        System.out.println(ans);
    }
}
