package algo_1012;
import java.io.*;
import java.util.*;
public class swea_2383 {
	static int N, ans;
	static int[][] map;
	static List<Point> person;
	static List<Point> stair;
	static boolean[] selected;
	static class Point{
		int r, c, dis;
		public Point(int r, int c, int dis) {
			super();
			this.r = r;
			this.c = c;
			this.dis = dis;
		}
	}
	static int distance(int pr, int pc, int sr, int sc) {
		return Math.abs(pr-sr) + Math.abs(pc-sc);
	}
	static void set(int depth) {
		if(depth == person.size()) {
			move();
			return;
		}
		
		selected[depth] = true;
		set(depth+1);
		selected[depth] = false;
		set(depth+1);
	}
	
	static void move() {
		List<Point> stair1 = new ArrayList<>();
		List<Point> stair2 = new ArrayList<>();

		for(int i=0; i<person.size(); i++) {
			Point p = person.get(i);
			if(selected[i]) {
				stair1.add(new Point(p.r, p.c, distance(p.r, p.c, stair.get(0).r, stair.get(0).c)));
				continue;
			}
			stair2.add(new Point(p.r, p.c, distance(p.r, p.c, stair.get(1).r, stair.get(1).c)));
		}
		
		stair1.sort((o1,o2) -> Integer.compare(o1.dis, o2.dis));
		stair2.sort((o1,o2) -> Integer.compare(o1.dis, o2.dis));
		int time = 0;
		while(!stair1.isEmpty() || !stair2.isEmpty()) {
			
			
			int down1 = 0;
			int down2 = 0;
			
			/*			----------------------------------------------------------*/	
//			System.out.println("time : "+time);
//			System.out.println(stair.get(0).dis);
//			for(int i=0; i<stair1.size(); i++) {
//				System.out.print("stair1 : ");
//				System.out.println(stair1.get(i).dis+" ");
//			}
//			
//			System.out.println();
//			
//			System.out.println(stair.get(1).dis);
//			for(int i=0; i<stair2.size(); i++) {
//				System.out.print("stair2 : ");
//				System.out.println(stair2.get(i).dis+" ");
//			}
//			System.out.println();
			/*			----------------------------------------------------------*/
			
			for(int i=0; i<stair1.size(); i++) {
				Point p = stair1.get(i);
				p.dis -= 1;
				if(p.dis == (stair.get(0).dis * -1) - 1) {
					stair1.remove(i);
					i--;
					continue;
				}
				if(down1 < 3 && p.dis < 0) {
					down1 += 1;
				}
				else if(down1 == 3 && p.dis < 0) {
					p.dis = 0;
				}
				//System.out.println("down 1 : "+down1);
				//System.out.println();
			}
			
			for(int i=0; i<stair2.size(); i++) {
				Point p = stair2.get(i);
				p.dis -= 1;
				if(p.dis == (stair.get(1).dis * -1) - 1) {
					stair2.remove(i);
					i--;
					continue;
				}
				if(down2 < 3 && p.dis < 0) {
					down2 += 1;
				}
				else if(down2 == 3 && p.dis < 0) {
					p.dis = 0;
				}
				//System.out.println("down 2 : " + down2);
				//System.out.println();
			}
			time += 1;
		}
		//System.out.println("time check : "+ time);
		//System.out.println();
		ans = Math.min(time, ans);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;
			
			map = new int[N][N];
			person = new ArrayList<>();
			stair = new ArrayList<>();
			for(int r=0; r<N; r++) {
				token = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					map[r][c] = Integer.parseInt(token.nextToken());
					if(map[r][c] > 1) {
						stair.add(new Point(r, c, map[r][c]));
						continue;
					}
					if(map[r][c] == 1) {
						person.add(new Point(r, c, map[r][c]));
					}
				}
			}
			//System.out.println(person.size());
			selected = new boolean[person.size()];
			set(0);
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
