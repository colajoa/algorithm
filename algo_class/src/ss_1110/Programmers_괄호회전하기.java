package ss_1110;

import java.io.*;
import java.util.*;

public class Programmers_괄호회전하기 {
    static int solution(String s) {
        List<Character> list = new ArrayList<>();
        Stack<Character> stack = new Stack();
        int answer = 0;
        int length = s.length();
        int size = length;
        for (int i = 0; i < length; i++) {
            list.add(s.charAt(i));
        }

        while (length != 0) {
            stack.push(list.get(0));
            boolean flag = false;
            for (int i = 1; i < size; i++) {
                char c = list.get(i);

                if (stack.isEmpty() && (c == ')' || c == ']' || c == '}')) {
                    stack.push(c);
                    break;
                } else if (c == ')' && stack.peek() == '(')
                    stack.pop();
                else if (c == ']' && stack.peek() == '[')
                    stack.pop();
                else if (c == '}' && stack.peek() == '{')
                    stack.pop();
                else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) {
                answer += 1;
            }
            list.add(0, list.remove(size - 1));
            System.out.println(list);
            stack.clear();
            length -= 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        // System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        // System.out.println(solution("[)(]"));
        // System.out.println(solution("}}}"));
    }
}