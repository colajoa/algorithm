package algo_1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_17471 {
	static int[][] sector;
	static int[] population;
	static boolean[] selected;
	static boolean[] visited;
	static int N, ans;
	
	static void comb(int depth) {
		if(depth == N+1) {
			if(check()) {
				ans = Math.min(count(),ans);
			}
			return;
		}
		
		selected[depth] = true;
		comb(depth+1);
		selected[depth] = false;
		comb(depth+1);
	}
	
	static boolean check() {
		Queue<Integer> red  = new ArrayDeque<>();
		Queue<Integer> blue = new ArrayDeque<>(); 
		boolean flag = selected[1];
		visited = new boolean[N+1];
		red.add(1);
		int cnt=1;
		for(int i=2; i<=N; i++) {
			if(flag == selected[i]) {
				cnt+=1;
				red.add(i);
			}
			else {
				blue.add(i);
			}
		}
		
		if(cnt==N || cnt == 0) return false;
		
		bfs(red, selected[1]);
		bfs(blue, !selected[1]);
		
		for(int i=1; i<=N; i++) {
			if(!visited[i])
				return false;
		}
		return true;
	}
	
	static void bfs(Queue<Integer> q, boolean flag) {
		//System.out.println(q.peek());
		visited[q.peek()] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=1; i<=N; i++) {
				if(!visited[i] && sector[now][i] != 0 && selected[i] == flag) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
	
	static int count() {
		int red = 0;
		int blue = 0;
		
		for(int i=1; i<=N; i++) {
			if(selected[i]) {
				red += population[i];
			}
			else {
				blue += population[i];
			}
		}
		return Math.abs(red-blue);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		
		N = Integer.parseInt(br.readLine());
		
		sector = new int[N+1][N+1];
		population = new int[N+1];
		selected = new boolean[N+1];
		ans = Integer.MAX_VALUE;
		
		token = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=N; i++) {
			population[i] = Integer.parseInt(token.nextToken());
		}
		
		for (int from = 1; from <= N; from++) {
			token = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(token.nextToken());
			for(int s=0; s<size; s++) {
				int to = Integer.parseInt(token.nextToken());
				sector[to][from] = 1;
				sector[from][to] = 1;
			}
		}
		
		comb(1);
		
//		for(int i=1; i<=N; i++) {
//			System.out.println(Arrays.toString(sector[i]));
//		}
		
		System.out.println(ans==Integer.MAX_VALUE ? -1 : ans);
	}
}
