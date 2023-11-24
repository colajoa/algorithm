package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_30702 {
    static int R, C;
    static char[][] A, B;
    static boolean[][] visited;
    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    static void dfs(int r, int c) {
        visited[r][c] = true;
        q.add(new int[] { r, c });

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && A[r][c] == A[nr][nc]) {
                dfs(nr, nc);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        R = Integer.parseInt(token.nextToken());
        C = Integer.parseInt(token.nextToken());

        A = new char[R][C];
        B = new char[R][C];
        visited = new boolean[R][C];
        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                A[r][c] = str.charAt(c);
            }
        }

        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                B[r][c] = str.charAt(c);
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (!visited[r][c]) {
                    dfs(r, c);
                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        A[p[0]][p[1]] = B[r][c];
                    }
                }
            }
        }
        boolean flag = true;
        for (int r = 0; r < R && flag; r++) {
            for (int c = 0; c < C && flag; c++) {
                if (A[r][c] != B[r][c]) {
                    flag = false;
                }

            }
        }

        if (!flag) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
