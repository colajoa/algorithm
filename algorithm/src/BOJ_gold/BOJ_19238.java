package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_19238 {
    static int N, M, fuel, taxiR, taxiC, guestNum, dis;
    static int[][] map;
    static int[][] visited;
    static Guest[] guest;
    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static class Guest {
        int dptR, dptC, arrR, arrC;

        public Guest(int dptR, int dptC, int arrR, int arrC) {
            this.dptR = dptR;
            this.dptC = dptC;
            this.arrR = arrR;
            this.arrC = arrC;
        }
    }

    static void checkGuest() {
        visited = new int[N][N];
        visited[taxiR][taxiC] = 1;
        q.add(new int[] { taxiR, taxiC });

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (map[now[0]][now[1]] > 0 && map[now[0]][now[1]] < 999) {
                if (dis > visited[now[0]][now[1]] - 1) {
                    dis = visited[now[0]][now[1]] - 1;
                    taxiR = now[0];
                    taxiC = now[1];
                } else if (dis == visited[now[0]][now[1]] - 1) {
                    if ((now[0] < taxiR) || (now[0] == taxiR && now[1] < taxiC)) {
                        taxiR = now[0];
                        taxiC = now[1];
                    }
                }
            }

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && visited[nr][nc] == 0 && map[nr][nc] != 999) {
                    visited[nr][nc] = visited[now[0]][now[1]] + 1;
                    q.add(new int[] { nr, nc });
                }
            }
        }
    }

    static void goDes() {
        visited = new int[N][N];
        visited[taxiR][taxiC] = 1;
        q.add(new int[] { taxiR, taxiC });

        taxiR = guest[guestNum].arrR;
        taxiC = guest[guestNum].arrC;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == taxiR && now[1] == taxiC) {
                dis = visited[now[0]][now[1]] - 1;
            }

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && visited[nr][nc] == 0 && map[nr][nc] != 999) {
                    visited[nr][nc] = visited[now[0]][now[1]] + 1;
                    q.add(new int[] { nr, nc });
                }
            }
        }

    }

    static void print(int[][] arr) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(arr[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean check() {
        visited = new int[N][N];
        visited[taxiR][taxiC] = 1;
        q.add(new int[] { taxiR, taxiC });

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && visited[nr][nc] == 0 && map[nr][nc] != 999) {
                    visited[nr][nc] = visited[now[0]][now[1]] + 1;
                    q.add(new int[] { nr, nc });
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if ((Math.abs(map[r][c]) < 999 && Math.abs(map[r][c]) > 0) && visited[r][c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        fuel = Integer.parseInt(token.nextToken());

        map = new int[N][N];
        guest = new Guest[M + 1];
        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());

                if (map[r][c] == 1) {
                    map[r][c] = 999;
                }
            }
        }

        token = new StringTokenizer(br.readLine());

        taxiR = Integer.parseInt(token.nextToken()) - 1;
        taxiC = Integer.parseInt(token.nextToken()) - 1;

        for (int m = 1; m < M + 1; m++) {
            token = new StringTokenizer(br.readLine());
            int dptR = Integer.parseInt(token.nextToken()) - 1;
            int dptC = Integer.parseInt(token.nextToken()) - 1;
            int arrR = Integer.parseInt(token.nextToken()) - 1;
            int arrC = Integer.parseInt(token.nextToken()) - 1;

            map[dptR][dptC] = m;
            guest[m] = new Guest(dptR, dptC, arrR, arrC);
        }

        if (!check()) {
            fuel = -1;
        }

        while (fuel != -1) {
            dis = Integer.MAX_VALUE;

            checkGuest();
            fuel -= dis;
            if (fuel < 0) {
                fuel = -1;
                break;
            }

            guestNum = map[taxiR][taxiC];
            map[taxiR][taxiC] = 0;

            goDes();
            fuel -= dis;
            if (fuel < 0) {
                fuel = -1;
                break;
            }

            M -= 1;
            fuel += dis * 2;

            if (M == 0) {
                break;
            }
        }

        System.out.println(fuel);
    }
}
