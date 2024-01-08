package softeer.Level3;

import java.io.*;
import java.util.*;

public class softeer_동계_테스트_시점_예측 {
    static int N, M, cnt, time;
    static int[][] map;
    static int[][] melted;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static Queue<int[]> q = new ArrayDeque<>();

    static void bfs() {
        melted[0][0] = -1;
        q.add(new int[] { 0, 0 });
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (melted[nr][nc] == 0 && map[nr][nc] == 0) {
                        melted[nr][nc] = -1;
                        q.add(new int[] { nr, nc });
                    } else if (melted[nr][nc] > -1 && map[nr][nc] == 1) {
                        melted[nr][nc] += 1;
                        if (melted[nr][nc] > 1) {
                            melted[nr][nc] = -1;
                            map[nr][nc] = 0;
                            cnt -= 1;
                        }
                    }
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

        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
                if (map[r][c] == 1) {
                    cnt += 1;
                }
            }
        }

        while (cnt != 0) {
            melted = new int[N][M];
            bfs();
            time += 1;
        }

        System.out.println(time);
    }
}
