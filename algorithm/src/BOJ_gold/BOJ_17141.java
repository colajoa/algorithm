package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_17141 {
    static int N, M, ans = Integer.MAX_VALUE, time, size;
    static int[][] map;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int[][] visited;
    static Point[] selected;
    static Queue<Point> q = new ArrayDeque<>();
    static List<Point> virus = new ArrayList<>();

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void pick(int depth, int start) {
        if (depth == M) {
            bfs();

            if (time == -1) {
                return;
            }
            ans = Math.min(ans, time - 1);
            return;
        }

        for (int i = start; i < size; i++) {
            Point v = virus.get(i);
            selected[depth] = new Point(v.r, v.c);
            pick(depth + 1, i + 1);
        }
    }

    static void bfs() {
        visited = new int[N][N];

        for (Point s : selected) {
            visited[s.r][s.c] = 1;
            q.add(new Point(s.r, s.c));
        }

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && visited[nr][nc] == 0 && map[nr][nc] != 1) {
                    visited[nr][nc] = visited[now.r][now.c] + 1;

                    q.add(new Point(nr, nc));
                }
            }
        }

        int zero = 0;
        time = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (visited[r][c] == 0 && map[r][c] != 1) {
                    zero += 1;
                } else {
                    time = Math.max(time, visited[r][c]);
                }
            }
        }
        if (zero > 0) {
            time = -1;
        }

    }

    static void print() {
        System.out.println();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(visited[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N][N];
        selected = new Point[M];
        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());

                if (map[r][c] == 2) {
                    virus.add(new Point(r, c));
                }
            }
        }

        size = virus.size();
        pick(0, 0);
        if (ans != Integer.MAX_VALUE) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }
}
