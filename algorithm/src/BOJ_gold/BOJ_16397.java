package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_16397 {
    static int N, T, G, ans;
    static Queue<Button> q = new ArrayDeque<>();
    static boolean[] visited = new boolean[100000];

    static class Button {
        int num, cnt;

        public Button(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    static boolean bfs() {
        while (!q.isEmpty()) {
            Button now = q.poll();
            if (now.cnt > T)
                continue;
            if (now.num == G) {
                ans = Math.min(ans, now.cnt);
                return true;
            }

            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    int next = now.num + 1;

                    if (next > 99999)
                        continue;
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(new Button(next, now.cnt + 1));
                    }
                } else if (i == 1) {
                    if (now.num == 0)
                        continue;
                    int next = now.num * 2;

                    if (next > 99999)
                        continue;

                    int len = (int) (Math.log10(next));

                    int minus = (int) Math.pow(10, len);

                    next -= minus;

                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(new Button(next, now.cnt + 1));
                    }
                }
            }

        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        T = Integer.parseInt(token.nextToken());
        G = Integer.parseInt(token.nextToken());

        ans = T + 1;
        visited[N] = true;
        q.add(new Button(N, 0));

        if (bfs()) {
            System.out.println(ans);
        } else {
            System.out.println("ANG");
        }
    }
}
