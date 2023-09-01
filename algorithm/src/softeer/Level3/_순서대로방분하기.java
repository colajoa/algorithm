package softeer.Level3;

import java.io.*;
import java.util.*;

public class _순서대로방분하기 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int ans = 0;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Point[] order;

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void dfs(int sr, int sc, int next) {

        if (sr == order[M].r && sc == order[M].c) {
            ans += 1;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = sr + dr[i];
            int nc = sc + dc[i];

            if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && map[nr][nc] != 1) {
                visited[nr][nc] = true;
                if (map[nr][nc] == 0) {
                    dfs(nr, nc, next);
                } else if (nr == order[next].r && nc == order[next].c) {
                    dfs(nr, nc, next + 1);
                }
                visited[nr][nc] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        order = new Point[M + 1];

        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        for (int m = 1; m < M + 1; m++) {
            token = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(token.nextToken()) - 1;
            int c = Integer.parseInt(token.nextToken()) - 1;
            map[r][c] = 2;
            order[m] = new Point(r, c);
        }

        dfs(order[1].r, order[1].c, 2);

        System.out.println(ans);
    }
}
