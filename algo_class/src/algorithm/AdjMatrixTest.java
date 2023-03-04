package algorithm;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest {
	static int[][] adjmatrix;
	static int N;
	static boolean[] visited;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int E = sc.nextInt();

		adjmatrix = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < E; i++) { // 간선 정보에 해당하는 부분만 덮어씀
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjmatrix[from][to] = adjmatrix[to][from] = 1; // 무향 그래프
		}
		dfs(0);
//		bfs();
	}

	private static void dfs(int cur) {
		// TODO Auto-generated method stub
		visited[cur] = true;
		System.out.print((char)(cur + 'A')+" ");
		for (int i = 0; i < N; i++) {
			if (!visited[i] && adjmatrix[cur][i] != 0) { // 방문하지 않았으며 인접한 경우
				dfs(i);
			}
		}
	}

	private static void bfs() {
		// TODO Auto-generated method stub
		// 0정점 시작점
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N];

		visited[0] = true;
		queue.add(0);

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print((char)(cur + 'A')+" ");

			// 현재 정점의 인접 정점들에 큐에 넣어서 차후 탐색하도록 만들기
			for (int i = 0; i < N; i++) {
				if (!visited[i] && adjmatrix[cur][i] != 0) { // 방문하지 않았으며 인접한 경우
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}
}
