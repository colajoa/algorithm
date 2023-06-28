package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            Stack<Character> parenthesis = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    parenthesis.push(str.charAt(i));
                } else if (str.charAt(i) == ')') {
                    if (!parenthesis.isEmpty() && parenthesis.peek() == '(') {
                        parenthesis.pop();
                    } else {
                        parenthesis.push(str.charAt(i));
                    }
                }
            }
            if (parenthesis.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
