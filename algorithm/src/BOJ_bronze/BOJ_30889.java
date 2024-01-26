package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_30889 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        char[][] cinema = new char[10][20];

        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 20; c++) {
                cinema[r][c] = '.';
            }
        }
        for (int n = 0; n < N; n++) {
            String str = br.readLine();

            cinema[str.charAt(0) - 'A'][Integer.parseInt(str.substring(1)) - 1] = 'o';
        }

        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 20; c++) {
                sb.append(cinema[r][c]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
