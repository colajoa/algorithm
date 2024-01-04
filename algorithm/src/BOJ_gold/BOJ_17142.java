package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_17142 {
    static int N, M, size, time, ans = Integer.MAX_VALUE;
    static int[][] map;
    static int[][] visited;
    static int[][] selected;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static List<int[]> virus = new ArrayList<>();
    static Queue<int[]> q = new ArrayDeque<>();

    static void pick(int depth, int start) {
        if (depth == M) {
            bfs();
            if (time == -1) {
                return;
            }
            ans = Math.min(time - 1, ans);
            return;
        }

        for (int i = start; i < size; i++) {
            int[] v = virus.get(i);
            selected[depth][0] = v[0];
            selected[depth][1] = v[1];
            pick(depth + 1, i + 1);
        }
    }

    static void print() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(visited[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void bfs() {
        visited = new int[N][N];

        for (int[] v : selected) {
            visited[v[0]][v[1]] = 1;
            q.add(v);
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < N && visited[nr][nc] == 0 && map[nr][nc] != 1) {
                    visited[nr][nc] = visited[now[0]][now[1]] + 1;
                    q.add(new int[] { nr, nc });
                }
            }
        }

        int zero = 0;
        time = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (visited[r][c] == 0 && map[r][c] == 0) {
                    zero += 1;
                } else if (visited[r][c] > 0 && map[r][c] == 0) {
                    time = Math.max(time, visited[r][c]);
                }
            }
        }

        if (zero > 0) {
            time = -1;
        } else if (zero == 0 && time == 0) {
            time = 1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        map = new int[N][N];
        selected = new int[M][2];
        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());

                if (map[r][c] == 2) {
                    virus.add(new int[] { r, c });
                }
            }
        }

        size = virus.size();
        pick(0, 0);
        if (ans != Integer.MAX_VALUE) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }
}
