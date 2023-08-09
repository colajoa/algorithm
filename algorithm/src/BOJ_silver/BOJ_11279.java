package BOJ_silver;

import java.io.*;
import java.util.PriorityQueue;

public class BOJ_11279 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int n = 0; n < N; n++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (q.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(q.poll()).append("\n");
                }
                continue;
            }
            q.add(num);
        }
        System.out.println(sb);
    }
}
