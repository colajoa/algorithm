package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_12050 {
    static int R, C, N;
    static int[][] map;
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

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] == 1) {
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

        for (int t = 1; t < T + 1; t++) {
            sb.append("Case #").append(t).append(":\n");

            token = new StringTokenizer(br.readLine());
            R = Integer.parseInt(token.nextToken());
            C = Integer.parseInt(token.nextToken());

            map = new int[R][C];

            for (int r = 0; r < R; r++) {
                String str = br.readLine();
                for (int c = 0; c < C; c++) {
                    map[r][c] = str.charAt(c) - '0';
                }
            }

            N = Integer.parseInt(br.readLine());

            for (int n = 0; n < N; n++) {
                token = new StringTokenizer(br.readLine());

                String command = token.nextToken();

                if (command.equals("Q")) {

                    visited = new boolean[R][C];
                    int cnt = 0;
                    for (int r = 0; r < R; r++) {
                        for (int c = 0; c < C; c++) {
                            if (map[r][c] == 1 && !visited[r][c]) {
                                visited[r][c] = true;
                                q.add(new Point(r, c));
                                bfs();
                                cnt += 1;
                            }
                        }
                    }
                    sb.append(cnt).append("\n");

                } else {
                    int r = Integer.parseInt(token.nextToken());
                    int c = Integer.parseInt(token.nextToken());
                    int num = Integer.parseInt(token.nextToken());

                    map[r][c] = num;
                }
            }
        }
        System.out.println(sb);
    }
}
