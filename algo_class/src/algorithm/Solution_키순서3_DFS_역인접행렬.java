package algorithm;

import java.io.*;
import java.util.*;

public class Solution_키순서3_DFS_역인접행렬 {
	static int N, M;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			int[][] adjMatrix = new int[N + 1][N + 1];
			int[][] radjMatrix = new int[N + 1][N + 1];
			
			StringTokenizer token = null;

			for (int m = 0; m < M; m++) {
				token = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(token.nextToken());
				int b = Integer.parseInt(token.nextToken());

				radjMatrix[b][a] = adjMatrix[a][b] = 1; // a보다 b가 키가 크다.
			}
			int answer = 0;

			for (int i = 1; i <= N; i++) {
				cnt = 0;
				dfs(i, adjMatrix, new boolean[N + 1]);
				dfs(i, radjMatrix, new boolean[N + 1]);
				if (cnt == N - 1)
					answer++;
			}
			System.out.println("#" + t + " " + answer);
		}
	}

	static void dfs(int cur, int[][] adjMatrix, boolean[] visited) { // cur 학생부터 자신보다 키가 큰 학생따라 탐색

		visited[cur] = true;

		for (int i = 1; i <= N; i++) { // 자신의 인접 행렬 들여다보기
			if (adjMatrix[cur][i] == 1 && !visited[i]) { // adjMatrix 전달대상에 따라
											// i가 cur보다 키가 큰 경우(i가 cur보다 키가 작은 경우)
				cnt++; // adjMatrix 전달대상에 따라 나보다 큰(작은) 학생 카운트;
				dfs(i, adjMatrix, visited);
			}
		}
	}
}
