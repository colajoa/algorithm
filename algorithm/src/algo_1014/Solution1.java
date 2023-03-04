import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution1 {
	static int N, max, ans;
	static int days;
	static int[] tree;
	static class Tree {
		int h, days;
		public Tree(int h, int days) {
			this.h = h;
			this.days = days;
		}
	}
	static void find(int height, int depth, boolean doWater) {
		if (height == max) {
			days = Math.min(days, depth); 
			return;
		}
		
		if(height > max) {
			return;
		}
//		System.out.println(depth);

		
//		if(depth+1%2 == 1) {
//			find(height+1, depth+1, true);
//		}
//		else if(depth+1%2 == 2){
//			find(height+2, depth+1, true);
//		}
		
		
		if(!doWater) {
			if(depth+1%2==1) {
				System.out.println("height " + (height+1));
				find(height+1, depth+1, true);
				//find(height+1, depth+1, false);
			}
			else {
				System.out.println("height " + (height+2));
				find(height+2, depth+1, true);
				//find(height+2, depth+1, false);
			}
		}
		
		else {
			find(height, depth+1, false);
			
		}
}
	
	static int bfs(int tree) {
		PriorityQueue<Tree> q = new PriorityQueue<>((o1,o2)->Integer.compare(o1.days, o2.days));
		q.add(new Tree(tree, 0));
		
		int depth = 0;
		while(!q.isEmpty()) {
			
						
				Tree t = q.poll();
				
				if(t.h == max) {
					depth = t.days;
					
					break;
				}
				if(depth%2==1) {
					q.add(new Tree(t.h + 1, t.days+1));
					q.add(new Tree(t.h, t.days+1));
				}
				else {
					q.add(new Tree(t.h+2, t.days+1));
					q.add(new Tree(t.h, t.days+1));
				}
			}
			
		
		return depth;
	}
	static void find2(int height, int depth) {
		if (height == max) {
			days = Math.min(days, depth); 
			return;
		}
		
		if(height > max) {
			return;
		}
		
		if(depth+1%2==1) {
			find2(height+1, depth+2);
			find2(height+2, depth+1);
		}
		else {
			find2(height+2, depth+2);
			find2(height+1, depth+1);
		}
		
}
	
	
//	static void water(int height, int depth, int cnt) {
//		if(height == max) {
//			days += Math.min(days, depth);
//			return;
//		}
//		
//		if(height > max) return;
//		
//		if(depth+1%2==1) {
//			water(height+1, depth+1, cnt+1);
//		}
//		else {
//			water(height+2, depth+1, cnt+1);
//		}
//		water(height, depth+1, cnt+1);
//	}
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			ans = 0;
			tree = new int[N];
			
			token = new StringTokenizer(br.readLine());
			max = 0;
			for (int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(token.nextToken());
				if(max < tree[i]) max = tree[i];
			}
			
//			System.out.println(Arrays.toString(tree));
//			System.out.println(max);

//			for (int i = N - 2; i > -1; i--) {
//				days = Integer.MAX_VALUE;
//				find(tree[i], 0, false);
//				//days = Integer.MAX_VALUE;
//				find(tree[i], 0, true);
//				ans += days;
//			}
//			
			for(int i=0; i<N; i++) {
				if(max==tree[i]) {
					ans+=0;
					continue;
				}
				days = bfs(tree[i]);
				ans += days;
			}
//			for (int i = 0; i <N; i++) {
//				days = Integer.MAX_VALUE;
//				find2(tree[i], 0);
//				days = Integer.MAX_VALUE;
//				find2(tree[i]+1, 1);
//				
//				days = days == Integer.MAX_VALUE ? 0 : days;
//				ans += days;
//			}
			
//			for (int i = N - 2; i > -1; i--) {
//				days = Integer.MAX_VALUE;
//				water(tree[i], 0, 0);
//				water(tree[i], 0, 1);
//				ans += days;
//			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}