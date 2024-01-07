package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_23288 {
    static int N, M, K, sr, sc, ans = 0;
    static int[][] map;
    static int[][] dice = new int[4][3];
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Queue<int[]> q = new ArrayDeque<>();

    static int bfs(int r, int c) {
        boolean[][] visited = new boolean[N][M];
        visited[r][c] = true;
        q.add(new int[] { r, c });
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] == map[r][c]) {
                    visited[nr][nc] = true;
                    cnt += 1;
                    q.add(new int[] { nr, nc });
                }
            }
        }
        return cnt;
    }

    /*
     * 0 2 0
     * 4 1 3
     * 0 5 0
     * 0 6 0
     */
    static void move(int dir) {
        int temp = 0;
        switch (dir) {
            /*
             * 북
             * 0 1 0
             * 4 5 3
             * 0 6 0
             * 0 2 0
             */
            case 0:
                temp = dice[0][1];

                for (int i = 0; i < 3; i++) {
                    dice[i][1] = dice[i + 1][1];
                }

                dice[3][1] = temp;
                break;

            /*
             * 동
             * 0 2 0
             * 6 4 1
             * 0 5 0
             * 0 3 0
             */
            case 1:
                temp = dice[3][1];

                dice[3][1] = dice[1][2];
                for (int i = 2; i > 0; i--) {
                    dice[1][i] = dice[1][i - 1];
                }

                dice[1][0] = temp;
                break;

            /*
             * 남
             * 0 6 0
             * 4 2 3
             * 0 1 0
             * 0 5 0
             */
            case 2:
                temp = dice[3][1];

                for (int i = 3; i > 0; i--) {
                    dice[i][1] = dice[i - 1][1];
                }

                dice[0][1] = temp;
                break;

            /*
             * 서
             * 0 2 0
             * 1 3 6
             * 0 5 0
             * 0 4 0
             */
            case 3:
                temp = dice[3][1];

                dice[3][1] = dice[1][0];
                for (int i = 0; i < 2; i++) {
                    dice[1][i] = dice[1][i + 1];
                }

                dice[1][2] = temp;
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        K = Integer.parseInt(token.nextToken());

        dice[0][1] = 2;
        dice[1][0] = 4;
        dice[1][1] = 1;
        dice[1][2] = 3;
        dice[2][1] = 5;
        dice[3][1] = 6;

        map = new int[N][M];

        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        int dir = 1;
        for (int k = 0; k < K; k++) {
            int nr = sr + dr[dir];
            int nc = sc + dc[dir];

            if (!(nr >= 0 && nr < N && nc >= 0 && nc < M)) {
                dir = (dir + 2) % 4;
                nr = sr + dr[dir];
                nc = sc + dc[dir];
            }

            sr = nr;
            sc = nc;
            move(dir);
            ans += bfs(sr, sc) * map[sr][sc];

            int next = 0;
            if (dice[3][1] > map[sr][sc]) {
                next = 1;
            } else if (dice[3][1] < map[sr][sc]) {
                next = -1;
            }

            dir = (4 + (dir + next) % 4) % 4;
        }
        System.out.println(ans);
    }
}
