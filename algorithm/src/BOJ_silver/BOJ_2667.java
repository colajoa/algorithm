package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2667 {
    static int N, cnt;
    static boolean[][] visited;
    static int[][] houses;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static List<Integer> ans = new ArrayList<>();

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void bfs(int r, int c) {
        Queue<Point> q = new ArrayDeque<>();
        visited[r][c] = true;
        q.add(new Point(r, c));

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1)
                    continue;

                if (!visited[nr][nc] && houses[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    cnt += 1;
                    q.add(new Point(nr, nc));
                }
            }
        }
        ans.add(cnt);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        houses = new int[N][N];

        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < N; c++) {
                houses[r][c] = str.charAt(c) - '0';
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c] && houses[r][c] == 1) {
                    cnt = 1;
                    bfs(r, c);
                }
            }
        }
        Collections.sort(ans);
        System.out.println(ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
