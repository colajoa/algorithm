package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_6907 {
    static int flooring, R, C, cnt;
    static char[][] map;
    static boolean[][] visited;
    static List<Integer> list = new ArrayList<>();
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

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[nr][nc] == '.') {
                    cnt += 1;
                    visited[nr][nc] = true;
                    q.add(new Point(nr, nc));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        flooring = Integer.parseInt(br.readLine());
        R = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == '.' && !visited[r][c]) {
                    cnt = 1;
                    visited[r][c] = true;
                    q.add(new Point(r, c));
                    bfs();
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        cnt = 0;
        int size = list.size();

        for (int i = 0; i < size; i++) {
            int floor = list.get(i);

            if (flooring >= floor) {
                cnt += 1;
                flooring -= floor;
            } else {
                break;
            }
        }

        if (cnt == 1) {
            System.out.println(cnt + " room, " + flooring + " square metre(s) left over");
        } else {
            System.out.println(cnt + " rooms, " + flooring + " square metre(s) left over");
        }
    }
}
