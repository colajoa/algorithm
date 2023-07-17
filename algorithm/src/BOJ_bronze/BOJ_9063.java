package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_9063 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;

        int N = Integer.parseInt(br.readLine());
        int minx = Integer.MAX_VALUE, miny = Integer.MAX_VALUE;
        int maxx = Integer.MIN_VALUE, maxy = Integer.MIN_VALUE;
        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());
            minx = Math.min(x, minx);
            miny = Math.min(y, miny);
            maxx = Math.max(x, maxx);
            maxy = Math.max(y, maxy);
        }
        System.out.println(Math.abs(minx - maxx) * Math.abs(miny - maxy));
    }
}