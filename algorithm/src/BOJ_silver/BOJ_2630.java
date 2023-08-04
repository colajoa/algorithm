package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2630 {
    static int N, ans;
    static int[][] paper;

    static void divide(int r, int c, int N, int color) {
        if (N == 0)
            return;
        if (conquer(r, c, N, color)) {
            ans += 1;
            return;
        }

        divide(r, c, N / 2, color);
        divide(r, c + N / 2, N / 2, color);
        divide(r + N / 2, c, N / 2, color);
        divide(r + N / 2, c + N / 2, N / 2, color);
    }

    static boolean conquer(int r, int c, int N, int color) {
        for (int row = r; row < r + N; row++) {
            for (int col = c; col < c + N; col++) {
                if (paper[row][col] == color)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                paper[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        ans = 0;
        divide(0, 0, N, 1);
        System.out.println(ans);

        ans = 0;
        divide(0, 0, N, 0);
        System.out.println(ans);
    }
}
