package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_1245 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static boolean flag;
    static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };

    static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int d = 0; d < 8; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (map[r][c] < map[nr][nc]) {
                    flag = false;
                }
                if (!visited[nr][nc] && map[nr][nc] == map[r][c]) {
                    dfs(nr, nc);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(token.nextToken());
            }
        }

        int ans = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (!visited[r][c]) {
                    flag = true;
                    dfs(r, c);
                    if (flag) {
                        ans += 1;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
