package algo_1013;
import java.io.*;
import java.util.*;
public class swea_5653_2 {
// 풀이 참고
	static int N, M, K;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	//static PriorityQueue<Cell> q;
	static Queue<Cell> q;
	static List<Cell> list;
	static class Cell {
		int r, c, time, life;
		boolean active;
		public Cell(int r, int c,int time,int life) {
			this.r = r;
			this.c = c;
			this.time = time;
			this.life = life;
		}
	}
	
	static void activate() {
		int time = 0;
		
		while(!q.isEmpty()) {
			
			if(time == K) {
				break;
			}
			
			int size = q.size();
			
			for(int i=0; i<size; i++) {
				Cell cell = q.poll();
				
				// 비활성화 상태면 시간을 줄이고 큐에 다시 담기
				if(!cell.active && cell.time != 0) {
					cell.time -= 1;
					q.add(cell);
					continue;
				}else if(cell.active) { //이미 활성상태 
					if(cell.time != 0) {
						cell.time -= 1;
						q.add(cell);
					}
					continue;
				}
				
				//else
				// 세포 활성화.
				// 1보다 큰 경우 큐에 담는다.
				// 사방탐색
				
				if(cell.life > 1) {
					cell.active = true;
					cell.time = cell.life - 2;
					q.add(cell);
				}
				
				for(int d=0; d<4; d++) {
					int nr = cell.r + dr[d];
					int nc = cell.c + dc[d];
					
					if(map[nr][nc] != 0) continue;
					
					map[nr][nc] = cell.life;
					q.add(new Cell(nr, nc, cell.life, cell.life));
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
			
			//map = new int[700][700];
			map = new int[350][350];
			//q = new PriorityQueue<>((o1,o2) -> Integer.compare(o2.life, o1.life));
			q = new ArrayDeque<>();
			list = new ArrayList<>();
			
//			for (int r = K-1; r < N+K-1; r++) {
//                token = new StringTokenizer(br.readLine());
//                for (int c = K-1; c < M+K-1; c++) {
//                    int n = Integer.parseInt(token.nextToken());
//                    if(n != 0) {
//                        map[r][c] = n;
//                        list.add(new Cell(r, c, n, n));
//                    }
//                }
//            }
			for(int r=0; r<N; r++) {
				token = new StringTokenizer(br.readLine());
				for(int c=0; c<M; c++) {
					map[r+150][c+150] = Integer.parseInt(token.nextToken());
					if(map[r+150][c+150] > 0) 
						//q.add(new Cell(r+150, c+150, map[r+150][c+150], map[r+150][c+150]));
						list.add(new Cell(r+150, c+150, map[r+150][c+150], map[r+150][c+150]));
				}
			}
			Collections.sort(list,(o1,o2) -> Integer.compare(o2.life, o1.life));
			q.addAll(list);
			activate();
			sb.append("#").append(t).append(" ").append(q.size()).append("\n");
		}
		System.out.println(sb);
	}
}
