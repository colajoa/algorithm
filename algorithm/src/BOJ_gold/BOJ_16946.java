package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_16946 {
    static int R, C, num = 1, cnt;
    static int[][] map;
    static int[][] ans;
    static boolean[][] walls;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Queue<Point> q = new ArrayDeque<>();
    static List<Integer> list = new ArrayList<>();

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

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !walls[nr][nc] && map[nr][nc] == 0) {
                    cnt += 1;
                    map[nr][nc] = num;
                    q.add(new Point(nr, nc));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        map = new int[R][C];
        ans = new int[R][C];
        walls = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                if (str.charAt(c) == '1') {
                    walls[r][c] = true;
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (!walls[r][c] && map[r][c] == 0) {
                    cnt = 1;
                    map[r][c] = num;
                    q.add(new Point(r, c));
                    bfs();
                    list.add(cnt);
                    num += 1;
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 0) {
                    boolean[] selected = new boolean[num];
                    ans[r][c] = 1;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr >= 0 && nr < R && nc >= 0 && nc < C && !selected[map[nr][nc]] && map[nr][nc] != 0) {
                            selected[map[nr][nc]] = true;
                            ans[r][c] += list.get(map[nr][nc] - 1) % 10;
                        }
                    }
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                sb.append(ans[r][c] % 10);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
