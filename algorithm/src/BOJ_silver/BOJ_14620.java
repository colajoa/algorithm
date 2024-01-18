package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_14620 {
    static int N, ans = 9999;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static void search(int depth, int sum) {
        if (depth == 3) {
            ans = Math.min(sum, ans);
            return;
        }

        for (int r = 1; r < N - 1; r++) {
            for (int c = 1; c < N - 1; c++) {
                if (!visited[r][c] && check(r, c)) {
                    visited[r][c] = true;
                    for (int d = 0; d < 4; d++) {
                        visited[r + dr[d]][c + dc[d]] = true;
                    }

                    search(depth + 1, sum + map[r][c] + map[r + dr[0]][c + dc[0]] + map[r + dr[1]][c + dc[1]]
                            + map[r + dr[2]][c + dc[2]] + map[r + dr[3]][c + dc[3]]);

                    visited[r][c] = false;
                    for (int d = 0; d < 4; d++) {
                        visited[r + dr[d]][c + dc[d]] = false;
                    }
                }
            }
        }
    }

    static boolean check(int r, int c) {
        for (int d = 0; d < 4; d++) {
            if (visited[r + dr[d]][c + dc[d]]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        search(0, 0);
        System.out.println(ans);
    }
}
