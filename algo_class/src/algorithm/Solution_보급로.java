package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_보급로 {
	static int map[][];
	static int N, INF = Integer.MAX_VALUE;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); 
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int r=0; r<N; r++) {
				String str = br.readLine();
				for(int c=0; c<N; c++) {
					map[r][c] = str.charAt(c) - '0';
				}
			}
			System.out.println("#"+t+" "+dijkstra(0, 0));
		}
	}
	
	private static int dijkstra(int startR, int startC) {
		
		// 출발지에서 자신으로의 최소비용을 저장할 배열 생성
		int[][] minCost = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				minCost[i][j] = INF;
			}
		}
		
		// 출발지에서 출발지로의 최소비용 0처리
		minCost[startR][startC] = 0;
		int r=0, c=0, nr, nc, minTime;
		
		while(true) {
			// step1. 미방문 정점중 최소 비용 정점 찾기
			r = c = -1;
			minTime = INF;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(!visited[i][j] && minTime>minCost[i][j]) {
						minTime = minCost[i][j];
						r = i;
						c = j;
					}
				}
			}
			//r,c -1일 경우는 더이상 갈 수 있는 정점이 없다.
			if(r==-1) return -1;

			visited[r][c] = true;
			if(r == N-1 && c == N-1) return minTime;
			
			// step2. 현재 정점 기준으로 인접한 정점들 들여다보며 경유비용이 유리한지 계산
			
			for(int d = 0; d<4; d++) {
				nr = r + dr[d];
				nc = c + dc[d];
				
				if(nr>=0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc] && minCost[nr][nc] > minTime + map[nr][nc]) {
					minCost[nr][nc] = minTime + map[nr][nc];
				}
			}
		}
	}
}
