package algo_1013;
import java.io.*;
import java.util.*;
public class swea_5653 {
	
	// visited != 0 && map != 0 비활성
	// visited == 0 && map != 0 활성
	// visited == -1 && map != 0 번식
	// visited == - == map 죽음
	
	static int N, M, K, ans, INF=-99;
	static int[][] map;
	static int[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<Cell> q;
	static class Cell {
		int r, c;
		public Cell(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static void activate() {
		int time = 0;
		
		while(!q.isEmpty()) {
			
			if(time == K) {
				return;
			}
			
			int size = q.size();
			int[][] temp = new int[350][350];
			
			for(int i=0; i<size; i++) {
				Cell cur = q.poll();
				int cr = cur.r;
				int cc = cur.c;
				
				// 비활성화 상태에서 시간 감소
				visited[cr][cc] -= 1;
				
				// 번식
				if(visited[cr][cc]==-1) {
					for(int d=0; d<4; d++) {
						int nr = cr + dr[d];
						int nc = cc + dc[d];
						
						// 다음 칸에 이미 있으면 생략 또는 먹기
						if(map[nr][nc] > 0) {
							// 동시에 들어온 경우
							if(temp[nr][nc] > 0 && map[nr][nc] == visited[nr][nc]) {
								if(map[nr][nc]<map[cr][cc]) {
									map[nr][nc] = map[cr][cc];
									visited[nr][nc] = map[cr][cc];
									temp[nr][nc] = map[cr][cc];
								}
							}
						}
						else {
							if(map[nr][nc] == INF) continue;
							if(map[nr][nc] == 0) {
								map[nr][nc] = map[cr][cc];
								visited[nr][nc] = map[cr][cc];
								temp[nr][nc] = map[cr][cc];
							}
						}
					}
				}
					if(visited[cr][cc] == -map[cr][cc]) {
						map[cr][cc] = INF;
					}
					temp[cr][cc] = map[cr][cc];
			}
			q.clear();
			ans = 0;
			
			for(int r=0; r<350; r++) {
				for(int c=0; c<350; c++) {
					if(temp[r][c]>0) {
						ans += 1;
						q.add(new Cell(r, c));
					}
				}
			}
			
			time += 1;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			token = new StringTokenizer(br.readLine());
			N = Integer.parseInt(token.nextToken());
			M = Integer.parseInt(token.nextToken());
			K = Integer.parseInt(token.nextToken());
			
			map = new int[350][350];
			visited = new int[350][350];
			q = new ArrayDeque<>();
			
			for(int r=0; r<N; r++) {
				token = new StringTokenizer(br.readLine());
				for(int c=0; c<M; c++) {
					map[r+150][c+150] = visited[r+150][c+150] = Integer.parseInt(token.nextToken());
					if(map[r+150][c+150] > 0) 
						q.add(new Cell(r+150, c+150));
				}
			}
			
			activate();
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
