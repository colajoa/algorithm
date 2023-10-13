package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_25192 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int n = 0; n < N; n++) {
            String str = br.readLine();
            if (str.equals("ENTER")) {
                cnt += set.size();
                set.clear();
                continue;
            }
            set.add(str);

        }

        System.out.println((cnt + set.size()));
    }
}
