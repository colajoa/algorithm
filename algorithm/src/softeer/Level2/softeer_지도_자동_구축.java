package softeer.Level2;

import java.io.*;
import java.util.*;

public class softeer_지도_자동_구축 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int a = 2;

        int d = (int) Math.pow(2, N) - 1;

        System.out.println((a + d) * (a + d));
    }
}
