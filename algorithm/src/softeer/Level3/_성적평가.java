package softeer.Level3;

import java.io.*;
import java.util.*;

public class _성적평가 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static List<Integer> scores = new ArrayList<>();
    static List<Integer> total = new ArrayList<>();
    static int[] org;
    static int[] result;
    static Map<Integer, Integer> rank = new HashMap<>();

    static void setting(List<Integer> list, int[] arr) {
        Collections.sort(list, Collections.reverseOrder());

        int cnt = 1;
        int acc = 1;
        rank.put(list.get(0), cnt);
        for (int n = 1; n < N; n++) {
            if (list.get(n).equals(list.get(n - 1))) {
                acc += 1;
            } else if (list.get(n) < list.get(n - 1)) {
                cnt += acc;
                acc = 1;
                rank.put(list.get(n), cnt);
            }
        }

        for (int n = 0; n < N - 1; n++) {
            sb.append(rank.get(arr[n])).append(" ");
        }
        sb.append(rank.get(arr[N - 1]));

        list.clear();
        rank.clear();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        N = Integer.parseInt(br.readLine());

        result = new int[N];
        for (int t = 0; t < 3; t++) {
            token = new StringTokenizer(br.readLine());
            org = new int[N];
            for (int n = 0; n < N; n++) {
                int score = Integer.parseInt(token.nextToken());

                scores.add(score);
                org[n] = score;
                result[n] += score;

                if (t == 2) {
                    total.add(result[n]);
                }
            }
            setting(scores, org);
            sb.append("\n");
        }

        setting(total, result);

        System.out.print(sb);
    }
}
