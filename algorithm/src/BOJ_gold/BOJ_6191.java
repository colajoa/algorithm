package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_6191 {
    static int R, C;
    static char[][] map;
    static StringBuilder sb = new StringBuilder();

    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static class Point {
        int r, c;
        List<Integer> pathR;
        List<Integer> pathC;

        public Point(int r, int c, List<Integer> pathR, List<Integer> pathC) {
            this.r = r;
            this.c = c;
            this.pathR = pathR;
            this.pathC = pathC;
        }
    }

    static void bfs() {
        Queue<Point> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[R + 1][C + 1];
        visited[1][1] = true;
        List<Integer> pathR = new ArrayList<>();
        List<Integer> pathC = new ArrayList<>();

        pathR.add(1);
        pathC.add(1);
        q.add(new Point(1, 1, pathR, pathC));

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.r == R && now.c == C) {
                print(now);
                return;
            }
            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 1 && nr <= R && nc >= 1 && nc <= C && !visited[nr][nc] && map[nr][nc] == '.') {
                    visited[nr][nc] = true;
                    List<Integer> newR = new ArrayList<>(now.pathR);
                    List<Integer> newC = new ArrayList<>(now.pathC);
                    newR.add(nr);
                    newC.add(nc);
                    q.add(new Point(nr, nc, newR, newC));
                }

            }
        }
    }

    static void print(Point now) {
        int len = now.pathR.size();
        for (int i = 0; i < len; i++) {
            sb.append(now.pathR.get(i)).append(" ").append(now.pathC.get(i)).append("\n");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        map = new char[R + 1][C + 1];
        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r + 1][c + 1] = str.charAt(c);
            }
        }

        bfs();

        System.out.println(sb);
    }
}
