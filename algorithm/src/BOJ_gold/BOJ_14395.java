package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_14395 {
    static long S, T;
    static String ans;
    static Set<Long> set = new HashSet<>();
    static Queue<Calc> q = new ArrayDeque<>();

    static class Calc {
        long num;
        String calc;

        public Calc(long num, String calc) {
            this.num = num;
            this.calc = calc;
        }
    }

    static boolean bfs() {
        set.add(S);
        q.add(new Calc(S, ""));

        while (!q.isEmpty()) {
            Calc now = q.poll();

            if (now.num == T) {
                ans = now.calc;
                return true;
            }
            for (int i = 0; i < 4; i++) {
                long next = now.num;
                String nextCalc = now.calc;
                switch (i) {
                    case 0:
                        next *= next;
                        nextCalc = nextCalc + "*";
                        break;
                    case 1:
                        next += next;
                        nextCalc = nextCalc + "+";
                        break;
                    case 2:
                        next -= next;
                        nextCalc = nextCalc + "-";
                        break;
                    case 3:
                        if (next != 0) {
                            next /= next;
                            nextCalc = nextCalc + "/";
                        }
                        break;
                }
                if (!set.contains(next)) {
                    set.add(next);
                    q.add(new Calc(next, nextCalc));
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        S = Long.parseLong(token.nextToken());
        T = Long.parseLong(token.nextToken());

        if (S == T) {
            System.out.println(0);
        } else {
            if (bfs()) {
                System.out.println(ans);
            } else {
                System.out.println(-1);
            }
        }
    }
}
