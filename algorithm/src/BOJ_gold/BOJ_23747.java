package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_23747 {
    static int R, C, sr, sc;
    static char[][] map;
    static char[][] ans;
    static boolean[][] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Map<Character, int[]> dir = new HashMap<>();
    static Queue<Point> q = new ArrayDeque<>();

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void bfs() {
        visited[sr][sc] = true;
        ans[sr][sc] = '.';
        q.add(new Point(sr, sc));
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && map[sr][sc] == map[nr][nc]) {
                    visited[nr][nc] = true;
                    ans[nr][nc] = '.';
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

        dir.put('U', new int[] { -1, 0 });
        dir.put('D', new int[] { 1, 0 });
        dir.put('L', new int[] { 0, -1 });
        dir.put('R', new int[] { 0, 1 });

        map = new char[R][C];
        ans = new char[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = str.charAt(c);
                ans[r][c] = '#';
            }
        }

        token = new StringTokenizer(br.readLine());
        sr = Integer.parseInt(token.nextToken()) - 1;
        sc = Integer.parseInt(token.nextToken()) - 1;

        String str = br.readLine();
        int len = str.length();
        for (int l = 0; l < len; l++) {
            char m = str.charAt(l);

            if (m == 'W') {
                bfs();
            }

            else {
                sr += dir.get(m)[0];
                sc += dir.get(m)[1];
            }
        }

        ans[sr][sc] = '.';
        for (int d = 0; d < 4; d++) {
            int nr = sr + dr[d];
            int nc = sc + dc[d];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                ans[nr][nc] = '.';
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                sb.append(ans[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
