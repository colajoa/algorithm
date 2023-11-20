package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_15661 {
    static int N;
    static int[][] map;
    static boolean[] selected;
    static int ans = Integer.MAX_VALUE;

    static void back(int start, int cnt) {
        if (cnt >= 1 && cnt <= N / 2) {
            int a = 0, b = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (selected[r] && selected[c]) {
                        a += map[r][c];
                    } else if (!selected[r] && !selected[c]) {
                        b += map[r][c];
                    }
                }
            }
            int min = Math.abs(a - b);
            ans = Math.min(ans, min);
        }

        for (int i = start; i < N; i++) {
            selected[i] = true;
            back(i + 1, cnt + 1);
            selected[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        selected = new boolean[N];

        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }
        back(0, 0);
        System.out.println(ans);
    }
}
