package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_1063 {
    static int N, stoneR, stoneC, kingR, kingC;
    static Map<String, int[]> dir = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        String str = token.nextToken();

        kingR = 8 - (str.charAt(1) - '0');
        kingC = str.charAt(0) - 'A';

        str = token.nextToken();

        stoneR = 8 - (str.charAt(1) - '0');
        stoneC = str.charAt(0) - 'A';

        N = Integer.parseInt(token.nextToken());
        dir.put("R", new int[] { 0, 1 });
        dir.put("L", new int[] { 0, -1 });
        dir.put("B", new int[] { 1, 0 });
        dir.put("T", new int[] { -1, 0 });
        dir.put("RT", new int[] { -1, 1 });
        dir.put("LT", new int[] { -1, -1 });
        dir.put("RB", new int[] { 1, 1 });
        dir.put("LB", new int[] { 1, -1 });

        int[] d;
        String com = "";
        for (int n = 0; n < N; n++) {
            com = br.readLine();

            d = dir.get(com);

            kingR += d[0];
            kingC += d[1];

            if (kingR < 0 || kingR >= 8 || kingC < 0 || kingC >= 8) {
                kingR -= d[0];
                kingC -= d[1];
                continue;
            }

            if (kingR == stoneR && kingC == stoneC) {
                stoneR += d[0];
                stoneC += d[1];
                if (stoneR < 0 || stoneR >= 8 || stoneC < 0 || stoneC >= 8) {
                    stoneR -= d[0];
                    stoneC -= d[1];
                    kingR -= d[0];
                    kingC -= d[1];
                    continue;
                }
            }
        }
        sb.append((char) (kingC + 'A')).append(8 - kingR).append("\n");
        sb.append((char) (stoneC + 'A')).append(8 - stoneR);
        System.out.println(sb);
    }
}
