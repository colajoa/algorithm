package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_14500 {
    static int N, M;
    static int[][] map;
    static int ans = -1;
    static boolean[][] visited;

    static void longR(int r, int c) {
        int sum = 0;
        for (int nc = c; nc < c + 4; nc++) {
            sum += map[r][nc];
        }
        ans = Math.max(ans, sum);
    }

    static void longC(int r, int c) {
        int sum = 0;
        for (int nr = r; nr < r + 4; nr++) {
            sum += map[nr][c];
        }
        ans = Math.max(ans, sum);
    }

    static void sqaure(int r, int c) {
        int sum = 0;
        sum += map[r][c] + map[r + 1][c] + map[r][c + 1] + map[r + 1][c + 1];
        ans = Math.max(ans, sum);
    }

    static void rectangleR(int r, int c) {
        int sum = map[r][c] + map[r][c + 1] + map[r][c + 2] + map[r + 1][c] + map[r + 1][c + 1] + map[r + 1][c + 2];

        ans = Math.max(ans, sum - (map[r][c] + map[r][c + 1]));
        ans = Math.max(ans, sum - (map[r][c + 1] + map[r][c + 2]));
        ans = Math.max(ans, sum - (map[r + 1][c] + map[r + 1][c + 1]));
        ans = Math.max(ans, sum - (map[r + 1][c + 1] + map[r + 1][c + 2]));
        ans = Math.max(ans, sum - (map[r][c] + map[r][c + 2]));
        ans = Math.max(ans, sum - (map[r + 1][c] + map[r + 1][c + 2]));
        ans = Math.max(ans, sum - (map[r][c] + map[r + 1][c + 2]));
        ans = Math.max(ans, sum - (map[r + 1][c] + map[r][c + 2]));
    }

    static void rectangleC(int r, int c) {
        int sum = map[r][c] + map[r][c + 1] + map[r + 1][c] + map[r + 1][c + 1] + map[r + 2][c] + map[r + 2][c + 1];

        ans = Math.max(ans, sum - (map[r][c] + map[r + 1][c]));
        ans = Math.max(ans, sum - (map[r + 1][c] + map[r + 2][c]));
        ans = Math.max(ans, sum - (map[r][c + 1] + map[r + 1][c + 1]));
        ans = Math.max(ans, sum - (map[r + 1][c + 1] + map[r + 2][c + 1]));
        ans = Math.max(ans, sum - (map[r][c] + map[r + 2][c]));
        ans = Math.max(ans, sum - (map[r][c + 1] + map[r + 2][c + 1]));
        ans = Math.max(ans, sum - (map[r][c] + map[r + 2][c + 1]));
        ans = Math.max(ans, sum - (map[r][c + 1] + map[r + 2][c]));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N][M];
        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(token.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M - 3; c++) {
                longR(r, c);
            }
        }

        for (int r = 0; r < N - 3; r++) {
            for (int c = 0; c < M; c++) {
                longC(r, c);
            }
        }

        for (int r = 0; r < N - 1; r++) {
            for (int c = 0; c < M - 1; c++) {
                sqaure(r, c);
            }
        }

        for (int r = 0; r < N - 1; r++) {
            for (int c = 0; c < M - 2; c++) {
                rectangleR(r, c);
            }
        }

        for (int r = 0; r < N - 2; r++) {
            for (int c = 0; c < M - 1; c++) {
                rectangleC(r, c);
            }
        }
        System.out.println(ans);
    }
}
