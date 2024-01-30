package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_11967 {
    static int N, M;
    static List<Point>[][] room;
    static boolean[][] lighting;
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

    static int cc = 0;

    static int bfs() {
        Queue<Point> q = new ArrayDeque<>();
        int cnt = 0;

        for (int n = 0; n < N; n++) {
            Arrays.fill(visited[n], false);
        }

        lighting[0][0] = true;
        visited[0][0] = true;
        q.add(new Point(0, 0));

        boolean turnOn = false;
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (Point next : room[now.r][now.c]) {
                if (!lighting[next.r][next.c]) {
                    lighting[next.r][next.c] = true;
                    cnt += 1;
                    turnOn = true;
                }
            }

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && lighting[nr][nc] && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }
            }
        }

        if (turnOn) {
            cnt += bfs();
        }
        return cnt;
    }

    static void print(boolean[][] arr) {
        System.out.println();

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(arr[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        lighting = new boolean[N][N];
        visited = new boolean[N][N];
        room = new ArrayList[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                room[r][c] = new ArrayList<>();
            }
        }
        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(token.nextToken()) - 1;
            int y1 = Integer.parseInt(token.nextToken()) - 1;
            int x2 = Integer.parseInt(token.nextToken()) - 1;
            int y2 = Integer.parseInt(token.nextToken()) - 1;

            room[x1][y1].add(new Point(x2, y2));
        }

        System.out.println(bfs() + 1);
    }
}
