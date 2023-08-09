package BOJ_gold;

import java.io.BufferedReader;

import java.io.*;
import java.util.*;

public class BOJ_7569 {
    static int N, M, H;
    static int[][][] box;
    static boolean[][][] visited;
    static Queue<Tomato> q = new ArrayDeque<>();
    static int ans = 0;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int[] dh = { -1, 1 };

    static class Tomato {
        int r, c, h, day;

        public Tomato(int r, int c, int h, int day) {
            this.r = r;
            this.c = c;
            this.h = h;
            this.day = day;
        }
    }

    static void print() {
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    System.out.print(box[n][m][h] + " ");
                }
                System.out.println();
            }
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Tomato now = q.poll();
            visited[now.r][now.c][now.h] = true;
            for (int i = 0; i < 4; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc][now.h] && box[nr][nc][now.h] == 0) {
                    visited[nr][nc][now.h] = true;
                    box[nr][nc][now.h] = 1;
                    q.add(new Tomato(nr, nc, now.h, now.day + 1));
                }
            }

            for (int i = 0; i < 2; i++) {
                int nh = now.h + dh[i];
                if (nh >= 0 && nh < H && !visited[now.r][now.c][nh] && box[now.r][now.c][nh] == 0) {
                    visited[now.r][now.c][nh] = true;
                    box[now.r][now.c][nh] = 1;
                    q.add(new Tomato(now.r, now.c, nh, now.day + 1));
                }
            }
            ans = now.day;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        M = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());
        H = Integer.parseInt(token.nextToken());

        box = new int[N][M][H];
        visited = new boolean[N][M][H];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                token = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    int tomato = Integer.parseInt(token.nextToken());
                    box[n][m][h] = tomato;
                    if (tomato == 1) {
                        q.add(new Tomato(n, m, h, 0));
                    }
                }
            }
        }

        bfs();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[n][m][h] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
