package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_3986 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        Stack<Character> stack = new Stack<>();
        for (int n = 0; n < N; n++) {
            String str = br.readLine();

            int len = str.length();

            for (int i = 0; i < len; i++) {
                char ch = str.charAt(i);
                if (stack.size() == 0) {
                    stack.add(ch);
                } else if (stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }

            if (stack.empty()) {
                cnt += 1;
            } else {
                stack.clear();
            }
        }

        System.out.println(cnt);
    }
}
