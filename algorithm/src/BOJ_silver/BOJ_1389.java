package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_1389 {
    static int N, M;
    static int[][] friends;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        friends = new int[N + 1][N + 1];
        int min = Integer.MAX_VALUE;
        int ans = -1;

        for (int r = 1; r < N + 1; r++) {
            for (int c = 1; c < N + 1; c++) {
                if (r != c) {
                    friends[r][c] = 10000001;
                }
            }
        }

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(token.nextToken());
            int to = Integer.parseInt(token.nextToken());

            friends[from][to] = friends[to][from] = 1;
        }

        for (int k = 1; k < N + 1; k++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < N + 1; j++) {
                    if (friends[i][j] > friends[i][k] + friends[k][j])
                        friends[i][j] = friends[i][k] + friends[k][j];
                }
            }
        }

        for (int i = 1; i < N + 1; i++) {
            int temp = 0;
            for (int j = 1; j < N + 1; j++) {
                temp += friends[i][j];
            }
            if (min > temp) {
                min = temp;
                ans = i;
            }
        }
        for (int r = 1; r < N + 1; r++) {
            for (int c = 1; c < N + 1; c++) {
                System.out.print(friends[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println(ans);
    }
}
