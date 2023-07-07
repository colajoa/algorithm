package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_3003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] orgPieces = { 1, 1, 2, 2, 2, 8 };

        for (int i = 0; i < 6; i++) {
            int piece = orgPieces[i] - Integer.parseInt(token.nextToken());

            sb.append(piece).append(" ");
        }

        System.out.println(sb);
    }
}