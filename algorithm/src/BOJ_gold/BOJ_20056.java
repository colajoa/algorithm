package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_20056 {
    static int N, M, K;
    static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static Queue<FireBall>[][] map;
    static Queue<FireBall> fireBalls = new ArrayDeque<>();

    static class FireBall {
        int r, c, m, s, d;

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static void move() {
        for (FireBall fireBall : fireBalls) {

            fireBall.r = (N + fireBall.r + (dr[fireBall.d] * (fireBall.s % N))) % N;
            fireBall.c = (N + fireBall.c + (dc[fireBall.d] * (fireBall.s % N))) % N;

            map[fireBall.r][fireBall.c].add(fireBall);
        }
    }

    static void merge() {
        boolean[][] visited = new boolean[N][N];

        int len = fireBalls.size();
        for (int l = 0; l < len; l++) {
            FireBall now = fireBalls.poll();
            if (visited[now.r][now.c])
                continue;

            visited[now.r][now.c] = true;
            if (map[now.r][now.c].size() == 1) {
                fireBalls.add(now);
            }

            else if (map[now.r][now.c].size() > 1) {
                int size = map[now.r][now.c].size();
                int mass = 0, speed = 0, even = 0, odd = 0;

                for (int i = 0; i < size; i++) {
                    FireBall fireBall = map[now.r][now.c].poll();

                    mass += fireBall.m;
                    speed += fireBall.s;

                    if (fireBall.d % 2 == 0) {
                        even += 1;
                    } else {
                        odd += 1;
                    }
                }
                mass /= 5;
                speed /= size;

                if (mass == 0) {
                    continue;
                }
                if (even == size || odd == size) {
                    for (int i = 0; i < 8; i += 2) {
                        fireBalls.add(new FireBall(now.r, now.c, mass, speed, i));
                    }
                } else {
                    for (int i = 1; i < 8; i += 2) {
                        fireBalls.add(new FireBall(now.r, now.c, mass, speed, i));
                    }
                }
            }
            map[now.r][now.c].clear();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        map = new ArrayDeque[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = new ArrayDeque<>();
            }
        }
        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(token.nextToken()) - 1;
            int c = Integer.parseInt(token.nextToken()) - 1;
            int mass = Integer.parseInt(token.nextToken());
            int s = Integer.parseInt(token.nextToken());
            int d = Integer.parseInt(token.nextToken());

            fireBalls.add(new FireBall(r, c, mass, s, d));
        }

        for (int k = 0; k < K; k++) {
            move();
            merge();
        }

        int sum = 0;
        for (FireBall fireBall : fireBalls) {
            sum += fireBall.m;
        }

        System.out.println(sum);
    }
}
