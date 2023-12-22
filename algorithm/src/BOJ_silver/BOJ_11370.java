package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_11370 {
    static int W, H;
    static int dr[] = { -1, 0, 1, 0 };
    static int dc[] = { 0, 1, 0, -1 };
    static List<int[]> S = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static char[][] map;

    static void dfs(int r, int c) {
        map[r][c] = 'S';

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == 'T') {
                dfs(nr, nc);
            }
        }
    }

    static void print() {
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                sb.append(map[r][c]);
            }
            sb.append("\n");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        while ((W = Integer.parseInt(token.nextToken())) != 0 && (H = Integer.parseInt(token.nextToken())) != 0) {
            map = new char[H][W];

            for (int r = 0; r < H; r++) {
                String str = br.readLine();
                for (int c = 0; c < W; c++) {
                    map[r][c] = str.charAt(c);
                    if (map[r][c] == 'S') {
                        S.add(new int[] { r, c });
                    }
                }
            }

            for (int[] s : S) {
                dfs(s[0], s[1]);
            }
            S.clear();
            print();
            token = new StringTokenizer(br.readLine());
        }

        System.out.println(sb);
    }
}
