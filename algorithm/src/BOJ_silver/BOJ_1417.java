package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_1417 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int N = Integer.parseInt(br.readLine());

        int dasom = Integer.parseInt(br.readLine());

        for (int n = 1; n < N; n++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int ans = 0;
        while (!pq.isEmpty()) {
            int now = pq.poll();

            if (now < dasom) {
                continue;
            }
            dasom += 1;
            pq.add(now - 1);
            ans += 1;
        }

        System.out.println(ans);
    }
}
