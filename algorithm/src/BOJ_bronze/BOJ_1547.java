package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_1547 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        int M = Integer.parseInt(br.readLine());

        int ball = 1;

        for (int m = 0; m < M; m++) {
            token = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(token.nextToken());
            int Y = Integer.parseInt(token.nextToken());

            if (X == Y)
                continue;
            else if (X != ball && Y != ball)
                continue;
            else if (X == ball && Y != ball) {
                ball = Y;
            } else if (X != ball && Y == ball) {
                ball = X;
            }
        }

        System.out.println(ball);
    }
}
