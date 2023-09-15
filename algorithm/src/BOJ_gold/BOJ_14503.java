package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_14503 {
    static int N, M, ans = 1;
    static int[][] map;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Queue<Robot> q = new ArrayDeque<>();

    static class Robot {
        int r, c, dir;

        public Robot(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            // print();
            Robot now = q.poll();

            boolean isCleaned = false;
            for (int d = 0; d < 4; d++) {
                now.dir = (now.dir + 3) % 4;
                int nr = now.r + dr[now.dir];
                int nc = now.c + dc[now.dir];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                    map[nr][nc] = 2;
                    ans += 1;
                    isCleaned = true;
                    q.add(new Robot(nr, nc, now.dir));
                    break;
                }
            }
            int nr = now.r + dr[(now.dir + 2) % 4];
            int nc = now.c + dc[(now.dir + 2) % 4];

            if (!isCleaned && nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] != 1) {
                q.add(new Robot(nr, nc, now.dir));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N][M];

        token = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(token.nextToken());
        int c = Integer.parseInt(token.nextToken());
        int dir = Integer.parseInt(token.nextToken());

        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(token.nextToken());
            }
        }

        q.add(new Robot(r, c, dir));
        map[r][c] = 2;
        bfs();
        // print();
        System.out.println(ans);
    }

    static void print() {
        System.out.println();
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                System.out.print(map[n][m] + " ");
            }
            System.out.println();
        }
    }
}
