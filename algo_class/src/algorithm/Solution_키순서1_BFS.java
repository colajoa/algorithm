package algorithm;

import java.io.*;
import java.util.*;

public class Solution_키순서1_BFS {
	static int N, M, adjMatrix[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			adjMatrix = new int[N+1][N+1];
			
			StringTokenizer token = null;
			
			for(int m=0; m<M; m++) {
				token = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(token.nextToken());
				int b = Integer.parseInt(token.nextToken());
				
				adjMatrix[a][b] = 1; // a보다 b가 키가 크다.
			}
			int answer = 0;
			
			for(int i=1; i<=N; i++) {
				if(gtBFS(i)+ltBFS(i)==N-1) answer++;
			}
			System.out.println("#"+t+" "+answer);
		}
	}
	
	static int gtBFS(int start) { // start 학생부터 자신보다 키가 큰 학생따라 탐색
		
		int cnt = 0; // 나보다 큰 학생 수
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		visited[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i=1; i<=N; i++) { // 자신의 인접 행렬 들여다보기
				if(adjMatrix[cur][i]==1 && !visited[i]) { // i가 cur보다 키가 크고 아직 탐색되지 않았다면
					cnt++;
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		return cnt;
	}
	static int ltBFS(int start) { // start 학생부터 자신보다 키가 작은 학생따라 탐색
		
		int cnt = 0; // 나보다 작은 학생 수
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[N+1];
		
		visited[start] = true;
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i=1; i<=N; i++) { // 자신의 인접 행렬 들여다보기
				if(adjMatrix[i][cur]==1 && !visited[i]) { // i가 cur보다 키가 작고 아직 탐색되지 않았다면
					cnt++;
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
		return cnt;
	}
}
