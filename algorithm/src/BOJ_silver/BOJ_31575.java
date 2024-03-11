package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_31575 {
    static int N, M;
    static int[][] map;
    static int[] dr = { 1, 0 };
    static int[] dc = { 0, 1 };
    static Queue<int[]> q = new ArrayDeque<>();

    static String bfs() {
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == M - 1 && now[1] == N - 1) {
                return "Yes";
            }

            for (int d = 0; d < 2; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (nr >= 0 && nr < M && nc >= 0 && nc < N && map[nr][nc] == 1) {
                    map[nr][nc] = 0;
                    q.add(new int[] { nr, nc });
                }
            }
        }

        return "No";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[M][N];
        for (int r = 0; r < M; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        map[0][0] = 0;
        q.add(new int[] { 0, 0 });
        System.out.println(bfs());
    }
}
