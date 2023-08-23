package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_1325 {
    static int N, M;
    static boolean[] visited;
    static int[] ans;
    static int cnt;
    static int max = -1;

    static List<Integer>[] com;
    static Queue<Integer> q = new ArrayDeque<>();

    static void bfs(int num) {
        visited[num] = true;
        q.add(num);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int n : com[now]) {
                if (!visited[n]) {
                    visited[n] = true;
                    ans[n] += 1;
                    q.add(n);
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

        com = new ArrayList[N + 1];
        ans = new int[N + 1];
        for (int n = 1; n < N + 1; n++) {
            com[n] = new ArrayList<>();
        }

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(token.nextToken());
            int from = Integer.parseInt(token.nextToken());

            com[to].add(from);
        }

        for (int n = 1; n < N + 1; n++) {
            visited = new boolean[N + 1];
            bfs(n);
        }

        for (int n = 1; n < N + 1; n++) {
            max = ans[n] > max ? ans[n] : max;
        }

        for (int n = 1; n < N + 1; n++) {
            if (ans[n] == max) {
                sb.append(n).append(" ");
            }
        }
        System.out.println(sb);
    }
}
