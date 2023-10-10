package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_17129 {
    static int N, M, cnt;
    static int[][] map;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static boolean bfs(int sr, int sc) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(sr, sc, 0));
        map[sr][sc] = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 1) {

                    if (map[nr][nc] > 2) {
                        cnt = now.cnt + 1;
                        return true;
                    }
                    map[nr][nc] = 1;
                    q.add(new Point(nr, nc, now.cnt + 1));
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        int sr = 0, sc = 0;
        map = new int[N][M];
        for (int n = 0; n < N; n++) {
            String str = br.readLine();
            for (int m = 0; m < M; m++) {
                map[n][m] = str.charAt(m) - '0';
                if (map[n][m] == 2) {
                    sr = n;
                    sc = m;
                }
            }
        }

        if (bfs(sr, sc)) {
            System.out.println("TAK");
            System.out.println(cnt);
        } else {
            System.out.println("NIE");
        }
    }
}
