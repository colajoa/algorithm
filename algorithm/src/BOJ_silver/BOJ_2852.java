package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_2852 {
    static int N;
    static int[] ATime = new int[2880];
    static int[] BTime = new int[2880];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        N = Integer.parseInt(br.readLine());
        int A = 0, B = 0, score = 0;
        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(token.nextToken());
            String[] time = token.nextToken().split(":");
            int seconds = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            if (team == 1) {
                ATime[seconds] = 1;
            } else {
                BTime[seconds] = 1;
            }
        }
        for (int i = 0; i < 2880; i++) {
            if (ATime[i] == 1) {
                score += 1;
            } else if (BTime[i] == 1) {
                score -= 1;
            }

            if (score > 0) {
                A += 1;
            } else if (score < 0) {
                B += 1;
            }
        }
        System.out.printf("%02d:%02d", A / 60, A % 60);
        System.out.printf("%02d:%02d", B / 60, B % 60);
    }
}
