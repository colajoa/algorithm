package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_16918 {
    static int R, C, N;
    static boolean[][] visited;
    static char[][][] ans;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Queue<int[]> q = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    static void print(int h) {
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                sb.append(ans[h][r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    ans[3][nr][nc] = '.';
                    if (ans[1][nr][nc] == 'O') {
                        q.add(new int[] { nr, nc });
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());
        N = Integer.parseInt(token.nextToken());

        ans = new char[4][R][C];
        visited = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                char ch = str.charAt(c);
                ans[0][r][c] = ch;
                if (ans[0][r][c] == 'O') {
                    ans[1][r][c] = '.';
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                            ans[1][nr][nc] = '.';
                        }

                    }
                } else if (ans[1][r][c] == '\0') {
                    ans[1][r][c] = 'O';
                }

                ans[2][r][c] = 'O';
                ans[3][r][c] = 'O';
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (ans[1][r][c] == 'O' && !visited[r][c]) {
                    ans[3][r][c] = '.';
                    visited[r][c] = true;
                    q.add(new int[] { r, c });
                    bfs();
                }
            }
        }
        if (N == 1) {
            print(0);
        } else if (N % 2 == 0) {
            print(2);
        } else if (N > 1) {
            if (N % 4 == 1) {
                print(3);
            } else if (N % 4 == 3) {
                print(1);
            }
        }
    }
}
