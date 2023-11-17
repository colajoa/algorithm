package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_26533 {
    static char[][] map;
    static int N;
    static int[] dr = { 0, 1 };
    static int[] dc = { 1, 0 };

    static String bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        map[0][0] = 'x';
        q.add(new int[] { 0, 0 });

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == N - 1 && now[1] == N - 1) {
                return "Yes";
            }

            for (int d = 0; d < 2; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == '.') {
                    map[nr][nc] = 'x';
                    q.add(new int[] { nr, nc });
                }
            }
        }

        return "No";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for (int r = 0; r < N; r++) {
            String str = br.readLine();
            for (int c = 0; c < N; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        System.out.println(bfs());
    }
}