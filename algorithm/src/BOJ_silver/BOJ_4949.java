package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_4949 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        while (true) {

            String str = br.readLine();
            Stack<Character> stack = new Stack<>();

            if (str.equals(".")) {
                break;
            }
            int len = str.length();
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) == '(' || str.charAt(i) == '[') {
                    stack.push(str.charAt(i));
                } else if (str.charAt(i) == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(str.charAt(i));
                    }
                } else if (str.charAt(i) == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(str.charAt(i));
                    }
                }
            }

            if (stack.size() == 0) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
