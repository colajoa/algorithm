package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_17427 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long ans = 0;
        for (int n = 1; n < N + 1; n++) {
            ans += n * (N / n);
        }

        System.out.println(ans);
    }
}
