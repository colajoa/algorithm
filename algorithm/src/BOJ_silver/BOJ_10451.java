package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_10451 {
    static int N, ans;
    static boolean[] visited;
    static List<Integer>[] list;

    static void dfs(int now) {
        visited[now] = true;

        for (int next : list[now]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            token = new StringTokenizer(br.readLine());

            list = new ArrayList[N + 1];
            visited = new boolean[N + 1];
            for (int n = 1; n < N + 1; n++) {
                list[n] = new ArrayList<>();
            }

            for (int n = 1; n < N + 1; n++) {
                int num = Integer.parseInt(token.nextToken());

                list[n].add(num);
            }
            ans = 0;
            for (int n = 1; n < N + 1; n++) {
                if (!visited[n]) {
                    ans += 1;
                    dfs(n);
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
