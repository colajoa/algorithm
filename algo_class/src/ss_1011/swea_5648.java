package ss_1011;

import java.io.*;
import java.util.*;

public class swea_5648 {
	// 0 상 1 하 2 좌 3 우
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] map;
	static int N, ans;
	static List<Atom> atom;
	
	static class Atom{
		int r, c, dir, eng;

		public Atom(int r, int c, int dir, int eng) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.eng = eng;
		}
	}
	
	static void move() {
		
		int zeroCount = 0;
		int size = atom.size();
		map = new int[4001][4001];
		while(zeroCount < size) {
			
			atom.sort((o1,o2)-> Integer.compare(o2.eng, o1.eng));
//			for(int i=0; i<N; i++) {
//				System.out.println("R : "+atom.get(i).r+ " C : "+atom.get(i).c+" "+atom.get(i).eng);
//			}
//			System.out.println();
			for(int i=0; i<N; i++) {
				//System.out.println(ans);
				Atom now = atom.get(i);
				now.r += dr[now.dir];
				now.c += dc[now.dir];
				//System.out.println(ans);
				if(now.eng == 0) continue;
				
				if(now.r < 0 || now.r > 4000 || now.c < 0 || now.c > 4000) {
					now.eng = 0;
					zeroCount += 1;
					continue;
				}
				
				if(map[now.r][now.c]==0) {
					map[now.r][now.c] = i+1;
					//System.out.println(map[now.r][now.c]);
					continue;
				}
				else {
					Atom past = atom.get(map[now.r][now.c]-1);
					
					ans += past.eng;
					past.eng = 0;
					zeroCount += 1;
					
					ans += now.eng;
					now.eng = 0;
					zeroCount += 1;
					
					map[now.r][now.c] = i+1;

				}
			}
			//System.out.println(zeroCount);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			atom = new ArrayList<>();
			ans = 0;
			for(int n=0; n<N; n++) {
				token = new StringTokenizer(br.readLine());
				// x
				int x = Integer.parseInt(token.nextToken());
				// y
				int y = Integer.parseInt(token.nextToken());
				int dir = Integer.parseInt(token.nextToken());
				int eng = Integer.parseInt(token.nextToken());
				
				atom.add(new Atom((y+1000)*2, (x+1000)*2, dir, eng));
				
			}
			move();
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
