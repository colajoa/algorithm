package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_20057 {
    static int N, sr, sc, num, start, ans = 0;
    static int[][] map;
    static int[][][] dir = {
            { { -2, 0, 2 }, { -1, -1, 10 }, { -1, 0, 7 }, { -1, 1, 1 }, { 0, -2, 5 }, { 1, -1, 10 }, { 1, 0, 7 },
                    { 1, 1, 1 }, { 2, 0, 2 } },
            { { -1, -1, 1 }, { -1, 1, 1 }, { 0, -2, 2 }, { 0, -1, 7 }, { 0, 1, 7 }, { 0, 2, 2 }, { 1, -1, 10 },
                    { 1, 1, 10 }, { 2, 0, 5 } },
            { { -2, 0, 2 }, { -1, -1, 1 }, { -1, 0, 7 }, { -1, 1, 10 }, { 0, 2, 5 }, { 1, -1, 1 }, { 1, 0, 7 },
                    { 1, 1, 10 }, { 2, 0, 2 } },
            { { -2, 0, 5 }, { -1, -1, 10 }, { -1, 1, 10 }, { 0, -2, 2 }, { 0, -1, 7 }, { 0, 1, 7 }, { 0, 2, 2 },
                    { 1, -1, 1 }, { 1, 1, 1 } }

    };
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { -1, 0, 1, 0 };

    static void move() {
        int sand = map[sr][sc];
        for (int d = 0; d < 9; d++) {
            int nr = sr + dir[start][d][0];
            int nc = sc + dir[start][d][1];

            int moveSand = (int) (sand * (0.01 * dir[start][d][2]));
            map[sr][sc] -= moveSand;

            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                map[nr][nc] += moveSand;
            } else {
                ans += moveSand;
            }
        }

        int nr = sr + dr[start];
        int nc = sc + dc[start];

        if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
            map[nr][nc] += map[sr][sc];
        } else {
            ans += map[sr][sc];
        }
        map[sr][sc] -= map[sr][sc];
        // print();
    }

    static void print() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(map[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }
        num = 1;
        sr = N / 2;
        sc = N / 2;

        start = 0;

        while (num != N - 1) {
            for (int i = 0; i < 2; i++) {
                for (int n = 0; n < num; n++) {
                    sr += dr[start];
                    sc += dc[start];
                    move();
                }
                start = (start + 1) % 4;
            }
            num += 1;
        }

        for (int i = 0; i < 3; i++) {
            for (int n = 0; n < num; n++) {
                sr += dr[start];
                sc += dc[start];
                move();
            }
            start = (start + 1) % 4;
        }

        System.out.println(ans);
    }
}
