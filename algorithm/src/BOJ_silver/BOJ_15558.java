package BOJ_silver;

import java.io.*;
import java.util.*;;

public class BOJ_15558 {
    static int N, k;
    static int[][] map;
    static boolean[][] visited;
    static int dc[] = { 1, -1, k };

    static class Point {
        int r, c, time;

        public Point(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    static void bfs() {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(0, 0, 0));

        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 3; i++) {
                int nr = now.r;
                int nc = now.c + dc[i];
                int time = now.time;
                if (i == 2) {
                    nr = now.r == 0 ? 1 : 0;
                }

                if (nc >= N) {
                    System.out.println(1);
                    return;
                }
                if (nc > time && !visited[nr][nc] && map[nr][nc] != 0) {
                    q.add(new Point(nr, nc, time + 1));
                    visited[nr][nc] = true;
                }
            }

        }

        System.out.println(0);
        return;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        k = Integer.parseInt(token.nextToken());

        map = new int[2][N];
        visited = new boolean[2][N];

        for (int r = 0; r < 2; r++) {
            String str = br.readLine();

            for (int c = 0; c < N; c++) {
                map[r][c] = str.charAt(c) - '0';
            }
        }

        bfs();
    }
}
