package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_30088 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        int N = Integer.parseInt(br.readLine());

        List<Integer> parts = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(token.nextToken());

            int sum = 0;
            for (int i = 0; i < num; i++) {
                sum += Integer.parseInt(token.nextToken());
            }
            parts.add(sum);
        
        }

        Collections.sort(parts);
        int[] sum = new int[N];
        sum[0] = parts.get(0);

        long ans = sum[0];
        for (int n = 1; n < N; n++) {
            sum[n] = sum[n - 1] + parts.get(n);
            ans += sum[n];
        }
        System.out.println(ans);
    }
}
