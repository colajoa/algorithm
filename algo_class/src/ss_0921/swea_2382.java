package ss_0921;

import java.util.*;
import java.io.*;

public class swea_2382 {

    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static List<Point> mi;
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    static class Point {
        int r;
        int c;
        int cnt;
        int dir;

        public Point(int r, int c, int cnt, int dir) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.dir = dir;
        }
    }

    static void move() {
        int time = 0;
        while (time < M) {
            int size = mi.size();
            for (int i = 0; i < size; i++) {
                int dir = mi.get(i).dir;
                int cnt = mi.get(i).cnt;
                int nr = mi.get(i).r + dr[dir];
                int nc = mi.get(i).c + dc[dir];
                map[nr][nc] += 1;
                mi.remove(i);
                mi.add(new Point(nr, nc, cnt, dir));
            }

            int chk = mi.size();
        }
    }

    static void bfs() {
        int time = 1;
        Queue<Point> q = new ArrayDeque<>();
        int nr = mi.get(i).r;
        Point n = q.peek();
        int dir = n.dir;
        int nr = n.r + dr[dir];
        int nc = n.c + dc[dir];
        int cnt = n.cnt;

        while (time < M) {

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            token = new StringTokenizer(br.readLine());

            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());
            K = Integer.parseInt(token.nextToken());
            mi = new ArrayList<>();

            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < K; i++) {
                token = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(token.nextToken());
                int c = Integer.parseInt(token.nextToken());
                int cnt = Integer.parseInt(token.nextToken());
                int dir = Integer.parseInt(token.nextToken());

                mi.add(new Point(r, c, cnt, dir));
            }
            move();
        }
    }
}
