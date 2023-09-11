package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_3182 {
    static int N;
    static int[] answer;
    static boolean[] visited;
    static int max = -1;
    static int ans = 0;
    static Queue<Integer> q = new ArrayDeque<>();

    static void bfs(int n) {
        q.add(n);
        int cnt = 1;
        visited[n] = true;

        while (!q.isEmpty()) {
            int now = answer[q.poll()];

            if (visited[now]) {
                if (max < cnt) {
                    max = cnt;
                    ans = n;
                }
            } else {
                visited[now] = true;
                cnt += 1;
                q.add(now);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        answer = new int[N + 1];

        for (int n = 1; n < N + 1; n++) {
            answer[n] = Integer.parseInt(br.readLine());
        }

        for (int n = 1; n < N + 1; n++) {
            visited = new boolean[N + 1];
            bfs(n);
        }

        System.out.println(ans);
    }
}
