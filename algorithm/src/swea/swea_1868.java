package swea;

import java.io.*;
import java.util.*;

public class swea_1868 {
    static int N;
    static char[][] map;
    static int[][] mine;
    static int ans;
    static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void bfs(int r, int c) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(r, c));

        mine[r][c] = -1;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 8; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && mine[nr][nc] != -1 && map[nr][nc] == '.') {
                    if (mine[nr][nc] == 0) {
                        q.add(new Point(nr, nc));
                    }
                    mine[nr][nc] = -1;
                }
            }
        }
    }

    static void count() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {

                if (map[r][c] == '.') {
                    int cnt = 0;
                    for (int d = 0; d < 8; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == '*')
                            cnt += 1;
                    }
                    mine[r][c] = cnt;

                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            N = Integer.parseInt(br.readLine());

            map = new char[N][N];
            mine = new int[N][N];
            ans = 0;
            for (int r = 0; r < N; r++) {
                String str = br.readLine();
                for (int c = 0; c < N; c++) {
                    map[r][c] = str.charAt(c);
                }
            }

            count();

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {

                    if (map[r][c] != '*' && mine[r][c] == 0) {
                        bfs(r, c);
                        ans += 1;
                    }
                }
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] != '*' && mine[r][c] > 0) {
                        ans += 1;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
