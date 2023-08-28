package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_7785 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();
        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());

            String name = token.nextToken();
            String command = token.nextToken();

            if (command.equals("enter")) {
                map.put(name, name);
            } else {
                map.remove(name);
            }
        }
        List<String> name = new ArrayList<>(map.keySet());
        name.sort((o1, o2) -> o2.compareTo(o1));
    
        for (String str : name) {
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}
