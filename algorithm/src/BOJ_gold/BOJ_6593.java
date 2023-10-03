package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_6593 {
    static char[][][] map;
    static boolean[][][] visited;
    static int L, R, C;
    static int sl, sr, sc;
    static int[] dl = { -1, 1, 0, 0, 0, 0 };
    static int[] dr = { 0, 0, -1, 0, 1, 0 };
    static int[] dc = { 0, 0, 0, 1, 0, -1 };
    static Queue<Point> q;

    static class Point {
        int l, r, c, cnt;

        public Point(int l, int r, int c, int cnt) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static String bfs() {
        q = new ArrayDeque<>();
        q.add(new Point(sl, sr, sc, 0));
        visited[sl][sr][sc] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 6; d++) {
                int nl = now.l + dl[d];
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nl >= 0 && nl < L && nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nl][nr][nc]
                        && map[nl][nr][nc] != '#') {
                    visited[nl][nr][nc] = true;
                    q.add(new Point(nl, nr, nc, now.cnt + 1));
                    if (map[nl][nr][nc] == 'E') {
                        return "Escaped in " + (now.cnt + 1) + " minute(s).";
                    }
                }
            }
        }

        return "Trapped!";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while ((L = Integer.parseInt(token.nextToken())) != 0
                && (R = Integer.parseInt(token.nextToken())) != 0 &&
                (C = Integer.parseInt(token.nextToken())) != 0) {

            map = new char[L][R][C];
            visited = new boolean[L][R][C];

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String str = br.readLine();
                    for (int c = 0; c < C; c++) {
                        map[l][r][c] = str.charAt(c);
                        if (map[l][r][c] == 'S') {
                            sl = l;
                            sr = r;
                            sc = c;
                        }
                    }
                }
                br.readLine();
            }

            sb.append(bfs()).append("\n");
            token = new StringTokenizer(br.readLine());
        }
        System.out.println(sb);
    }
}
