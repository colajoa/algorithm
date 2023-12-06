package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2075 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int N = Integer.parseInt(br.readLine());

        for (int r = 0; r < N; r++) {
            token = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                pq.add(Integer.parseInt(token.nextToken()));
            }
        }

        int n = 0;
        int ans = 0;
        while (n != N) {
            ans = pq.poll();
            n++;
        }

        System.out.println(ans);
    }
}
