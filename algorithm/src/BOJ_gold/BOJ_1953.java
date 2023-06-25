package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_1953 {
    static int N, max, bCnt, wCnt;
    static int[][] students;
    static int[] selected;
    static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sbb = new StringBuilder();
        StringBuilder sbw = new StringBuilder();

        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());
        students = new int[N + 1][N + 1];
        selected = new int[N + 1];

        for (int n = 1; n < N + 1; n++) {
            token = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(token.nextToken());
            for (int h = 0; h < H; h++) {
                int student = Integer.parseInt(token.nextToken());
                students[n][student] = students[student][n] = 1;
            }
        }

        for (int n = 1; n < N + 1; n++) {
            if (selected[n] != 0)
                continue;

            selected[n] = 1;
            q.add(n);

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int i = 1; i < N + 1; i++) {
                    if (selected[i] != 0)
                        continue;

                    if (students[now][i] == 1) {
                        selected[i] = selected[now] * -1;
                        q.add(i);
                    }
                }
            }
        }

        for (int n = 1; n < N + 1; n++) {
            if (selected[n] == 1) {
                bCnt += 1;
                sbb.append(n + " ");
            } else {
                wCnt += 1;
                sbw.append(n + " ");
            }
        }

        System.out.println(bCnt);
        System.out.println(sbb);
        System.out.println(wCnt);
        System.out.println(sbw);
    }
}
