package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_17140 {
    static int R, C, K, MR, MC, time;
    static int[][] map = new int[100][100];
    static PriorityQueue<Num> pq = new PriorityQueue<>();
    static int[] num = new int[101];

    static class Num implements Comparable<Num> {
        int num, cnt;

        public Num(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Num o) {
            if (this.cnt == o.cnt) {
                return this.num - o.num;
            }
            return this.cnt - o.cnt;
        }
    }

    static int setting() {

        while (time <= 100) {

            if (map[R][C] == K) {
                return time;
            }

            if (MR >= MC) {
                int max = -1;
                for (int r = 0; r < MR; r++) {
                    for (int c = 0; c < MC; c++) {
                        num[map[r][c]] += 1;
                    }

                    int cnt = 0;

                    for (int i = 1; i <= 100; i++) {
                        if (num[i] != 0) {
                            cnt += 2;
                            pq.add(new Num(i, num[i]));
                        }
                    }

                    max = cnt > max ? cnt : max;
                    Arrays.fill(num, 0);

                    int len = pq.size();

                    if (len > 50) {
                        for (int i = 0; i < 50; i++) {
                            Num num = pq.poll();
                            int m = (i * 2);
                            map[r][m] = num.num;
                            map[r][m + 1] = num.cnt;
                        }
                    } else {
                        for (int i = 0; i < len; i++) {
                            Num num = pq.poll();
                            int m = i * 2;
                            map[r][m] = num.num;
                            map[r][m + 1] = num.cnt;
                        }

                        for (int i = len * 2; i < 100; i++) {
                            map[r][i] = 0;
                        }
                    }

                    pq.clear();
                }

                MC = max;

            } else if (MR < MC) {
                int max = -1;
                for (int c = 0; c < MC; c++) {
                    for (int r = 0; r < MR; r++) {
                        num[map[r][c]] += 1;
                    }

                    int cnt = 0;

                    for (int i = 1; i <= 100; i++) {
                        if (num[i] != 0) {
                            cnt += 2;
                            pq.add(new Num(i, num[i]));
                        }
                    }

                    max = cnt > max ? cnt : max;
                    Arrays.fill(num, 0);

                    int len = pq.size();

                    if (len > 50) {
                        for (int i = 0; i < 50; i++) {
                            Num num = pq.poll();
                            int m = i * 2;
                            map[m][c] = num.num;
                            map[m + 1][c] = num.cnt;
                        }
                    } else {
                        for (int i = 0; i < len; i++) {
                            Num num = pq.poll();
                            int m = i * 2;
                            map[m][c] = num.num;
                            map[m + 1][c] = num.cnt;
                        }

                        for (int i = len * 2; i < 100; i++) {
                            map[i][c] = 0;
                        }
                    }

                    pq.clear();
                }

                MR = max;
            }

            time++;
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        R = Integer.parseInt(token.nextToken()) - 1;
        C = Integer.parseInt(token.nextToken()) - 1;
        K = Integer.parseInt(token.nextToken());

        for (int r = 0; r < 3; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < 3; c++) {
                map[r][c] = Integer.parseInt(token.nextToken());
            }
        }

        MR = 3;
        MC = 3;

        System.out.println(setting());
    }
}
