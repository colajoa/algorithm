package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_1822 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int nA = Integer.parseInt(token.nextToken());
        int nB = Integer.parseInt(token.nextToken());

        Set<Integer> A = new HashSet<>();

        token = new StringTokenizer(br.readLine());
        for (int n = 0; n < nA; n++) {
            A.add(Integer.parseInt(token.nextToken()));
        }

        token = new StringTokenizer(br.readLine());
        for (int n = 0; n < nB; n++) {
            A.remove(Integer.parseInt(token.nextToken()));
        }

        List<Integer> list = new ArrayList<>(A);
        Collections.sort(list);

        System.out.println(list.size());
        if (list.size() != 0) {
            for (int l : list) {
                System.out.print(l + " ");
            }
        }
    }
}
