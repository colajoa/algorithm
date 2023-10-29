package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_13265 {
    static int N, M;
    static List<Integer>[] list;
    static int[] colored;
    static Queue<Integer> q = new ArrayDeque<>();

    static String bfs() {

        for (int n = 1; n < N + 1; n++) {
            if (colored[n] == 0) {
                colored[n] = 1;
                q.add(n);
            }

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int next : list[now]) {
                    if (colored[now] == colored[next]) {
                        return "impossible";
                    }
                    if (colored[next] == 0) {
                        colored[next] = colored[now] * -1;
                        q.add(next);
                    }
                }
            }

        }
        return "possible";
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            token = new StringTokenizer(br.readLine());
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());

            list = new ArrayList[N + 1];
            colored = new int[N + 1];

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

            sb.append(bfs()).append("\n");
            q.clear();
        }

        System.out.println(sb);
    }
}
