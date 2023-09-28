package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_16173 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = { 1, 0 };
    static int[] dc = { 0, 1 };

    static String bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { 0, 0 });
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == N - 1 && now[1] == N - 1) {
                return "HaruHaru";
            }

            for (int d = 0; d < 2; d++) {
                int nr = now[0] + (dr[d] * map[now[0]][now[1]]);
                int nc = now[1] + (dc[d] * map[now[0]][now[1]]);

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[] { nr, nc });
                }
            }
        }

        return "Hing";
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

        System.out.println(bfs());
    }
}
