package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_20058 {
    static int N, Q, M, L, mass = 0, cnt = 0;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static int[][] icePlate;
    static int[][] grid;
    static boolean[][] visited;
    static Queue<int[]> q = new ArrayDeque<>();

    static void rotate(int r, int c) {
        for (int nr = 0; nr < L; nr++) {
            for (int nc = 0; nc < L; nc++) {
                grid[nc + r][(L + c) - 1 - nr] = icePlate[nr + r][nc + c];
            }
        }

        for (int nr = r; nr < r + L; nr++) {
            for (int nc = c; nc < c + L; nc++) {
                icePlate[nr][nc] = grid[nr][nc];
            }
        }
    }

    static void melt() {

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < M; c++) {
                if (icePlate[r][c] > 0) {
                    int cnt = 0;
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr >= 0 && nr < M && nc >= 0 && nc < M && icePlate[nr][nc] > 0) {
                            cnt += 1;
                        }
                    }

                    if (cnt < 3) {
                        q.add(new int[] { r, c });
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();

            icePlate[now[0]][now[1]] -= 1;
        }
    }

    static void dfs(int r, int c) {
        visited[r][c] = true;
        cnt += 1;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < M && nc >= 0 && nc < M && !visited[nr][nc] && icePlate[nr][nc] > 0) {
                dfs(nr, nc);
            }
        }
    }

    static void print(int[][] arr) {
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < M; c++) {
                System.out.print(arr[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        Q = Integer.parseInt(token.nextToken());

        M = (int) Math.pow(2, N);

        icePlate = new int[M][M];
        grid = new int[M][M];
        for (int r = 0; r < M; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                icePlate[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        token = new StringTokenizer(br.readLine());

        for (int q = 0; q < Q; q++) {
            L = Integer.parseInt(token.nextToken());
            L = (int) Math.pow(2, L);

            for (int r = 0; r < M; r += L) {
                for (int c = 0; c < M; c += L) {
                    if (L > 1) {
                        rotate(r, c);
                    }
                }
            }

            melt();
        }

        visited = new boolean[M][M];

        int ans = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < M; c++) {
                ans += icePlate[r][c];
                if (!visited[r][c] && icePlate[r][c] > 0) {
                    cnt = 0;
                    dfs(r, c);
                    if (cnt == 1) {
                        continue;
                    }
                    mass = Math.max(cnt, mass);
                }
            }
        }

        System.out.println(ans);
        System.out.println(mass);
    }
}
