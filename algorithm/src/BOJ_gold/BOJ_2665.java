package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_2665 {
    static int N;
    static int[][] map, ans;
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

                if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                    if (ans[nr][nc] > ans[now.r][now.c]) {
                        if (map[nr][nc] == 1) {
                            ans[nr][nc] = ans[now.r][now.c];
                        } else {
                            ans[nr][nc] = ans[now.r][now.c] + 1;
                        }
                        q.add(new Point(nr, nc));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        ans = new int[N][N];

        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < N; c++) {
                map[r][c] = str.charAt(c) - '0';
                ans[r][c] = Integer.MAX_VALUE;
            }
        }

        ans[0][0] = 0;
        q.add(new Point(0, 0));
        bfs();

        System.out.println(ans[N - 1][N - 1]);
    }
}
