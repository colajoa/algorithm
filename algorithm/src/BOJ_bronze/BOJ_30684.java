package BOJ_bronze;

import java.io.*;
import java.util.*;

public class BOJ_30684 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int n = 0; n < N; n++) {
            String str = br.readLine();

            if (str.length() == 3) {
                list.add(str);
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }
}
