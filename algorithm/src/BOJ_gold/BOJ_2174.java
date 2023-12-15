package BOJ_gold;

import java.io.*;
import java.util.*;

public class BOJ_2174 {
    static int A, B, N, M;
    static String message;
    static char[] dir = new char[] { 'N', 'E', 'S', 'W' };
    static Robot[] robots;
    static int[][] map;

    static Map<Character, int[]> move = new HashMap<>();

    static class Robot {
        int num, x, y;
        char dir;

        public Robot(int num, int x, int y, char dir) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static boolean command(int num, char order, int cycles) {
        Robot robot = robots[num];

        if (order == 'F') {
            int ny = robot.y;
            int nx = robot.x;
            int dy = move.get(robot.dir)[1];
            int dx = move.get(robot.dir)[2];

            for (int c = 0; c < cycles; c++) {
                ny += dy;
                nx += dx;
                // System.out.println("NY : " + ny + " NX : " + nx);
                if (ny < 0 || ny >= B || nx < 0 || nx >= A) {
                    message = "Robot " + num + " crashes into the wall";
                    return false;
                }

                if (map[ny][nx] != 0) {
                    message = "Robot " + num + " crashes into robot " + map[ny][nx];
                    return false;
                }
            }

            map[robot.y][robot.x] = 0;
            map[ny][nx] = num;
            // System.out.print("Before : " + robots[num].y + " " + robots[num].x);
            robots[num].y = ny;
            robots[num].x = nx;
            // System.out.println(" After : " + robots[num].y + " " + robots[num].x);
        } else if (order == 'L') {
            // System.out.println(move.get(robot.dir)[0]);
            int d = (move.get(robot.dir)[0] - cycles) % 4;
            d = d < 0 ? d + 4 : d;
            // System.out.println(d);
            // System.out.print("Before : " + robots[num].dir);
            robots[num].dir = dir[d];
            // System.out.println(" After : " + robots[num].dir);
        } else if (order == 'R') {
            int d = (move.get(robot.dir)[0] + cycles) % 4;
            // System.out.print("Before : " + robots[num].dir);
            robots[num].dir = dir[d];
            // System.out.println(" After : " + robots[num].dir);
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        // 가로 길이 X
        A = Integer.parseInt(token.nextToken());
        // 세로 길이 Y
        B = Integer.parseInt(token.nextToken());

        token = new StringTokenizer(br.readLine());
        N = Integer.parseInt(token.nextToken());
        M = Integer.parseInt(token.nextToken());

        move.put('N', new int[] { 0, -1, 0 });
        move.put('E', new int[] { 1, 0, 1 });
        move.put('S', new int[] { 2, 1, 0 });
        move.put('W', new int[] { 3, 0, -1 });
        map = new int[B][A];
        robots = new Robot[N + 1];

        for (int n = 1; n < N + 1; n++) {
            token = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(token.nextToken()) - 1;
            int y = B - Integer.parseInt(token.nextToken());
            char dir = token.nextToken().charAt(0);

            map[y][x] = n;
            robots[n] = new Robot(n, x, y, dir);
            // System.out.println("Robot : " + robots[n].y + " " + robots[n].x);
        }

        for (int m = 0; m < M; m++) {
            message = "OK";
            token = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(token.nextToken());
            char order = token.nextToken().charAt(0);
            int cycles = Integer.parseInt(token.nextToken());
            if (!command(num, order, cycles)) {
                for (int mm = m + 1; mm < M; mm++) {
                    br.readLine();
                }
                break;
            }

            // System.out.println(robots[num].y + " " + robots[num].x + " " +
            // robots[num].dir);
        }

        System.out.println(message);
    }
}