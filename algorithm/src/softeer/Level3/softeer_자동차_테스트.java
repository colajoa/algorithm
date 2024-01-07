package softeer.Level3;

import java.io.*;
import java.util.*;

public class softeer_자동차_테스트 {
    static int N, Q;
    static List<Integer> list = new ArrayList<>();
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(token.nextToken());
        Q = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            list.add(Integer.parseInt(token.nextToken()));
        }

        Collections.sort(list);

        int len = (int) Math.ceil((double) (N) / 2);
        int size = N - 1;
        for (int i = 0; i < len; i++) {
            int front = i;
            int tail = size - i;
            int num = front * tail;
            map.put(list.get(front), num);
            map.put(list.get(tail), num);
        }

        for (int q = 0; q < Q; q++) {
            int m = Integer.parseInt(br.readLine());

            if (map.containsKey(m)) {
                sb.append(map.get(m)).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }
}
