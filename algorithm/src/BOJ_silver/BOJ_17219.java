package BOJ_silver;

import java.util.*;
import java.io.*;

public class BOJ_17219 {
    static int N, M;
    static Map<String, String> account = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer token = new StringTokenizer(br.readLine());

        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());
            account.put(token.nextToken(), token.nextToken());
        }

        for (int m = 0; m < M; m++) {
            bw.write(account.get(br.readLine()) + "\n");
        }
        bw.close();
    }
}
