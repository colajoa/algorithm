package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_2573 {
    static int R, C, ans = 0, total = 0;
    static int[][] ocean;
    static boolean[][] melted;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Queue<Iceberg> icebergs = new ArrayDeque<>();

    static class Iceberg {
        int r, c, high;

        public Iceberg(int r, int c, int high) {
            this.r = r;
            this.c = c;
            this.high = high;
        }
    }

    static void melt() {
        melted = new boolean[R][C];
        int len = icebergs.size();
        for (int i = 0; i < len; i++) {
            Iceberg iceberg = icebergs.poll();
            for (int d = 0; d < 4; d++) {
                int nr = iceberg.r + dr[d];
                int nc = iceberg.c + dc[d];

                if (ocean[nr][nc] == 0 && !melted[nr][nc] && iceberg.high > 0) {
                    iceberg.high -= 1;
                    ocean[iceberg.r][iceberg.c] -= 1;
                    total -= 1;
                }
            }
            if (iceberg.high == 0) {
                melted[iceberg.r][iceberg.c] = true;
            } else {
                icebergs.add(iceberg);
            }
        }
        ans += 1;
    }

    static boolean bfs() {
        int len = icebergs.size();
        int minus = total;
        boolean[][] visited = new boolean[R][C];
        Queue<Iceberg> q = new ArrayDeque<>();
        int cnt = 0;

        for (int i = 0; i < len; i++) {
            Iceberg iceberg = icebergs.poll();

            if (!visited[iceberg.r][iceberg.c]) {
                cnt += 1;

                if (cnt >= 2) {
                    return false;
                }

                q.add(iceberg);
                visited[iceberg.r][iceberg.c] = true;
                while (!q.isEmpty()) {
                    Iceberg now = q.poll();
                    int zero = 0;

                    for (int d = 0; d < 4; d++) {
                        int nr = now.r + dr[d];
                        int nc = now.c + dc[d];

                        if (ocean[nr][nc] == 0) {
                            zero += 1;
                            continue;
                        }
                        if (!visited[nr][nc] && ocean[nr][nc] != 0) {
                            visited[nr][nc] = true;
                            q.add(new Iceberg(nr, nc, 0));
                        }

                    }
                    if (ocean[now.r][now.c] - zero >= 0) {
                        minus -= zero;
                    } else {
                        minus -= ocean[now.r][now.c];
                    }
                }
            }
            icebergs.add(iceberg);
        }

        if (cnt == 1 && minus == 0) {
            ans = 0;
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        ocean = new int[R][C];

        for (int r = 0; r < R; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                ocean[r][c] = Integer.parseInt(token.nextToken());
                if (ocean[r][c] != 0) {
                    total += ocean[r][c];
                    icebergs.add(new Iceberg(r, c, ocean[r][c]));
                }
            }
        }
        while (bfs()) {
            melt();
        }

        System.out.println(ans);
    }
}