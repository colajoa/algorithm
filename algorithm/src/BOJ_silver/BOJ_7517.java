package BOJ_silver;

import java.io.*;
import java.util.*;

public class BOJ_7517 {
    static int[][] map = new int[9][9];
    static List<Zero> zeros = new ArrayList<>();
    static boolean flag;
    static StringBuilder sb = new StringBuilder();

    static class Zero {
        int r, c;

        public Zero(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static void setting(int depth) {
        if (depth == zeros.size()) {
            flag = true;
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    sb.append(map[r][c]);
                }
                sb.append("\n");
            }
            sb.append("\n");

            return;
        }

        Zero zero = zeros.get(depth);
        int r = zero.r;
        int c = zero.c;

        for (int num = 1; num < 10 && !flag; num++) {
            if (check(r, c, num)) {
                map[r][c] = num;
                setting(depth + 1);
                map[r][c] = 0;
            }
        }
    }

    static boolean check(int r, int c, int num) {

        for (int nr = 0; nr < 9; nr++) {
            if (nr != r && map[nr][c] == num) {
                return false;
            }
        }

        for (int nc = 0; nc < 9; nc++) {
            if (nc != c && map[r][nc] == num) {
                return false;
            }
        }

        int nr = (r / 3) * 3;
        int nc = (c / 3) * 3;

        for (int dr = nr; dr < nr + 3; dr++) {
            for (int dc = nc; dc < nc + 3; dc++) {
                if (dr != r && dr != c && map[dr][dc] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int cnt = 1;
        for (int t = 1; t < T + 1; t++) {

            sb.append("Scenario #").append(t).append(":").append("\n");
            for (int r = 0; r < 9; r++) {
                String str = br.readLine();
                for (int c = 0; c < 9; c++) {
                    map[r][c] = str.charAt(c) - '0';
                    if (map[r][c] == 0) {
                        zeros.add(new Zero(r, c));
                    }
                }
            }

            flag = false;
            setting(0);

            zeros.clear();
            if (cnt++ != T) {
                br.readLine();
            }
        }

        System.out.println(sb);
    }
}
