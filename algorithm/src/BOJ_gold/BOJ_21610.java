package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_21610 {
    static int N, M;
    static long[][] map;
    static long ans = 0;
    static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1 };
    static int[] dc = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] cloudR = { N - 1, N - 1, N - 2, N - 2 };
    static int[] cloudC = { 0, 1, 0, 1 };
    static Queue<Point> clouds = new ArrayDeque<>();

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void move(int dir, int move) {

        for (Point cloud : clouds) {
            cloud.r = (N + cloud.r + (dr[dir] * (move % N))) % N;
            cloud.c = (N + cloud.c + (dc[dir] * (move % N))) % N;

            ans += 1;
            map[cloud.r][cloud.c] += 1;
        }

        check();

    }

    static void check() {
        boolean[][] visited = new boolean[N][N];
        while (!clouds.isEmpty()) {
            Point cloud = clouds.poll();
            visited[cloud.r][cloud.c] = true;
            for (int m = 1; m < 8; m += 2) {
                int nr = cloud.r + dr[m];
                int nc = cloud.c + dc[m];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] > 0) {
                    ans += 1;
                    map[cloud.r][cloud.c] += 1;
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] >= 2 && !visited[r][c]) {
                    ans -= 2;
                    map[r][c] -= 2;
                    clouds.add(new Point(r, c));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new long[N][N];
        clouds.add(new Point(N - 1, 1));
        clouds.add(new Point(N - 1, 0));
        clouds.add(new Point(N - 2, 1));
        clouds.add(new Point(N - 2, 0));
        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Long.parseLong(token.nextToken());
                ans += map[r][c];
            }
        }

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());

            int dir = Integer.parseInt(token.nextToken());
            int move = Integer.parseInt(token.nextToken());
            move(dir - 1, move);
        }

        System.out.println(ans);
    }
}
