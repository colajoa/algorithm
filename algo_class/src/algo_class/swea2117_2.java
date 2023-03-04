package algo_class;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea2117_2 {

    static int[][] map;
    static int N, M;
    static int ans;

    static void search(int k) {
        // 맵 전체를 돌면서 집의 서비스 제공을 받는 집의 갯수를 구해 맥스 값을 구한다.
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // getHouse를 통해서 범위 탐색
                // 기존 정답과 받아온 집의 갯수를 비교 최대 값을 찾는다.
                ans = Math.max(ans, getHouse(r, c, k));
            }
        }

    }

    // r, c에서 k-1만큼 상하좌우 검사
    static int getHouse(int r, int c, int k) {
        int house = 0;
        // 홈 방범 서비스 제공 범위
        for (int i = r - k + 1; i <= r + k - 1; i++) {
            for (int j = c - k + 1; j <= c + k - 1; j++) {
                // 거리 계산
                int dis = Math.abs(r - i) + Math.abs(c - j);
                // 도시 범위를 벗어나는 경우
                if (i < 0 || i >= N || j < 0 || j >= N)
                    continue;
                // 도시 범위 안에 있으면서 서비스 범위안에 있으면서 집인 경우
                if (dis <= k - 1 && map[i][j] == 1) {
                    // 집의 갯수를 1개 추가
                    house += 1;
                }
            }
        }

        // 발생 비용을 계산한다.
        // 집들에서 발생하는 비용 - 운영비용
        int cost = house * M - ((k * k) + (k - 1) * (k - 1));

        // 손해를 보지 않는다면 집의 갯수를 리턴
        if (cost >= 0) {
            return house;
        }
        // 손해를 본다면 -1 리턴
        else {
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            token = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(token.nextToken());
            M = Integer.parseInt(token.nextToken());

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                token = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(token.nextToken());
                }
            }
            ans = 0;
            // 서비스 전체를 제공하는 범위는 도시크기 + 1 범위이다.
            // 서비스 제공 범위 1 ~ 전체 범위
            for (int k = 1; k <= N + 2; k++) {
                search(k);
            }

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
