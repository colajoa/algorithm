package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_18404 {
    static int N, M, kr, kc;
    static int[] dr = { -2, -2, -1, -1, 1, 1, 2, 2 };
    static int[] dc = { -1, 1, -2, 2, -2, 2, -1, 1 };
    static boolean[][] visited;
    static int[][] map;

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        visited[kr][kc] = true;
        q.add(new int[] { kr, kc });

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 8; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (nr >= 1 && nr < N + 1 && nc >= 1 && nc < N + 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    map[nr][nc] = map[now[0]][now[1]] + 1;
                    q.add(new int[] { nr, nc });
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        token = new StringTokenizer(br.readLine());
        kr = Integer.parseInt(token.nextToken());
        kc = Integer.parseInt(token.nextToken());

        bfs();

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());
            sb.append(map[Integer.parseInt(token.nextToken())][Integer.parseInt(token.nextToken())]).append(" ");
        }

        System.out.println(sb);
    }
}
