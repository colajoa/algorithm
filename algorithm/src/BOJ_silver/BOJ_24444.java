package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_24444 {
    static int N, M, R;
    static int[] ans;
    static List<Integer>[] list;

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(R);
        int cnt = 1;
        ans[R] = cnt++;

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : list[now]) {
                if (ans[next] == 0) {
                    ans[next] = cnt++;
                    q.add(next);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());
        R = Integer.parseInt(token.nextToken());

        list = new ArrayList[N + 1];
        ans = new int[N + 1];
        for (int n = 1; n < N + 1; n++) {
            list[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(token.nextToken());
            int from = Integer.parseInt(token.nextToken());

            list[to].add(from);
            list[from].add(to);
        }

        for (int n = 1; n < N + 1; n++) {
            Collections.sort(list[n]);
        }

        bfs();

        for (int n = 1; n < N + 1; n++) {
            sb.append(ans[n]).append("\n");
        }

        System.out.println(sb);
    }
}
