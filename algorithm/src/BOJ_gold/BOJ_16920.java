package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_16920 {
    static int N, M, P, cnt;
    static int[][] map;
    static Queue<Point>[] players;
    static int[] move;
    static int[] ans;
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
        while (cnt != 0) {
            for (int p = 1; p < P + 1; p++) {
                for (int m = 0; m < move[p]; m++) {

                    int size = players[p].size();
                    for (int s = 0; s < size; s++) {
                        Point now = players[p].poll();
                        for (int d = 0; d < 4; d++) {
                            int nr = now.r + dr[d];
                            int nc = now.c + dc[d];

                            if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                                cnt -= 1;
                                map[nr][nc] = p;
                                ans[p] += 1;
                                players[p].add(new Point(nr, nc));
                            }
                        }
                    }

                    if (players[p].isEmpty()) {
                        break;
                    }
                }
            }
            boolean flag = true;
            for (int p = 1; p < P + 1; p++) {
                if (!players[p].isEmpty()) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        P = Integer.parseInt(token.nextToken());

        cnt = N * M;
        map = new int[N][M];
        players = new ArrayDeque[P + 1];
        move = new int[P + 1];
        ans = new int[P + 1];

        token = new StringTokenizer(br.readLine());
        for (int p = 1; p < P + 1; p++) {
            players[p] = new ArrayDeque<>();
            int dis = Integer.parseInt(token.nextToken());
            if (dis >= N || dis >= M) {
                dis = Math.max(N, M);
            }
            move[p] = dis;
        }

        for (int n = 0; n < N; n++) {
            String str = br.readLine();
            for (int m = 0; m < M; m++) {
                char ch = str.charAt(m);

                if (ch == '#') {
                    map[n][m] = -1;
                    cnt -= 1;
                } else if (ch == '.') {
                    map[n][m] = 0;
                } else {
                    map[n][m] = ch - '0';
                    players[map[n][m]].add(new Point(n, m));
                    cnt -= 1;
                    ans[map[n][m]] += 1;
                }
            }
        }

        bfs();
        for (int p = 1; p < P + 1; p++) {
            sb.append(ans[p]).append(" ");
        }

        System.out.println(sb);
    }
}