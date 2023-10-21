package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_16234 {
    static int N, L, R;
    static int[][] map;
    static int cnt = -1;
    static boolean flag = true;
    static List<Point> list = new ArrayList<>();
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void search() {
        Queue<Point> q = new ArrayDeque<>();

        while (flag) {
            boolean[][] visited = new boolean[N][N];
            boolean[][] check = new boolean[N][N];
            flag = false;
            cnt += 1;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (!visited[r][c]) {
                        visited[r][c] = true;
                        q.add(new Point(r, c));

                        while (!q.isEmpty()) {
                            Point now = q.poll();

                            for (int d = 0; d < 4; d++) {
                                int nr = now.r + dr[d];
                                int nc = now.c + dc[d];

                                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]
                                        && (Math.abs(map[now.r][now.c] - map[nr][nc]) >= L
                                                && Math.abs(map[now.r][now.c] - map[nr][nc]) <= R)) {
                                    flag = true;
                                    if (!check[now.r][now.c]) {
                                        check[now.r][now.c] = true;
                                        list.add(new Point(now.r, now.c));
                                    }
                                    if (!check[nr][nc]) {
                                        check[nr][nc] = true;
                                        list.add(new Point(nr, nc));
                                    }
                                    visited[nr][nc] = true;
                                    q.add(new Point(nr, nc));
                                }
                            }
                        }
                        int sum = 0;
                        int size = list.size();
                        for (Point p : list) {
                            sum += map[p.r][p.c];
                        }

                        if (size != 0 && sum != 0) {
                            sum /= size;
                            for (Point p : list) {
                                map[p.r][p.c] = sum;
                            }
                        }

                        list.clear();
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        L = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());

        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        search();
        
        System.out.println(cnt);
    }
}
