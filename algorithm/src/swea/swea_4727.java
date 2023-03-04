package swea;

import java.io.*;
import java.util.*;

public class swea_4727 {
    static int N, M, map[][];

    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static class Point {
        int r, c, time;

        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static int bfs() {
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        q.add(new Point(0, 0, 1));

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr == N - 1 && nc == N - 1) {
                    // System.out.println(now.time);
                    return now.time + 1;
                }

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] != 0) {
                    if (map[nr][nc] > 1) {
                        if (now.time % (map[nr][nc]) == 0) {
                            visited[nr][nc] = true;
                            q.add(new Point(nr, nc, now.time + 1));
                        } else {
                            q.add(new Point(now.r, now.c, now.time + 1));
                        }
                    } else {
                        // System.out.println(map[nr][nc]);
                        visited[nr][nc] = true;
                        q.add(new Point(nr, nc, now.time + 1));
                    }
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    static void print() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer token = null;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            token = new StringTokenizer(br.readLine());
            List<Point> zeros = new ArrayList<>();
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());
            int ans = Integer.MAX_VALUE;
            map = new int[N][N];
            for (int r = 0; r < N; r++) {
                token = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    map[r][c] = Integer.parseInt(token.nextToken());
                }
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (map[r][c] == 0) {
                        int cnt = 0;
                        for (int d = 0; d < 4; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 1) {
                                cnt += 1;
                            }
                        }
                        if (cnt == 2) {
                            zeros.add(new Point(r, c, M));
                        }
                    }
                }
            }
            // print();
            // System.out.println(zeros.size());
            for (int i = 0; i < zeros.size(); i++) {
                Point zero = zeros.get(i);

                map[zero.r][zero.c] = zero.time;

                ans = Math.min(ans, bfs());
                map[zero.r][zero.c] = 0;
            }

            sb.append("#").append(t).append(" ").append(ans - 1).append("\n");
        }
        System.out.println(sb);
    }
}