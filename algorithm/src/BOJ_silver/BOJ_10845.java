package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_10845 {
    static class Queue {
        private int[] queue;
        private int front = 0;
        private int back = -1;

        public Queue(int size) {
            queue = new int[size];
        }

        public void push(int num) {
            queue[++back] = num;
        }

        public int pop() {
            if (isEmpty()) {
                return -1;
            }
            return queue[front++];
        }

        public int size() {
            return back - front + 1;
        }

        public boolean isEmpty() {
            if (size() == 0) {
                return true;
            }
            return false;
        }

        public int front() {
            if (isEmpty()) {
                return -1;
            }
            return queue[front];
        }

        public int back() {
            if (isEmpty()) {
                return -1;
            }
            return queue[back];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue queue = new Queue(N);

        for (int n = 0; n < N; n++) {
            token = new StringTokenizer(br.readLine());

            switch (token.nextToken()) {
                case "push":
                    queue.push(Integer.parseInt(token.nextToken()));
                    break;
                case "pop":
                    sb.append(queue.pop()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(queue.front()).append("\n");
                    break;
                case "back":
                    sb.append(queue.back()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
