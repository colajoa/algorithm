package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_4677 {
    static int N, M;
    static char[][] map;
    static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
    static Queue<Point> q = new ArrayDeque<>();

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

            for (int d = 0; d < 8; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == '@') {
                    map[nr][nc] = '*';
                    q.add(new Point(nr, nc));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while ((N = Integer.parseInt(token.nextToken())) != 0 && (M = Integer.parseInt(token.nextToken())) != 0) {

            map = new char[N][M];

            for (int r = 0; r < N; r++) {
                String str = br.readLine();
                for (int c = 0; c < M; c++) {
                    map[r][c] = str.charAt(c);
                }
            }

            int cnt = 0;
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == '@') {
                        cnt += 1;
                        map[r][c] = '*';
                        q.add(new Point(r, c));
                        bfs();
                    }
                }
            }

            sb.append(cnt).append("\n");
            q.clear();
            token = new StringTokenizer(br.readLine());
        }
        System.out.println(sb);
    }
}
