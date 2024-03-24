package softeer.Level2;

import java.io.*;
import java.util.*;

public class softeer_X_marks_the_Spot {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());

            String S = token.nextToken();
            String T = token.nextToken();

            int len = S.length();

            for (int l = 0; l < len; l++) {
                char ch = S.charAt(l);

                if (ch == 'X' || ch == 'x') {
                    sb.append(T.toUpperCase().charAt(l));
                }
            }
        }

        System.out.println(sb);
    }
}
