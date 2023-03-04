package algo_class_0825;

import java.util.*;
import java.io.*;
public class KruskalMain {
	static int N;
	static int [][] edges;
	static int[] p;
	
	static void make() {
		p = new int[N];
		for(int i=0; i<N; i++) p[i] = i;
	}
	static int find(int a) {
		if(p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot ) return false;
		
		p[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		edges = new int[E][3];
		
		for(int e=0; e<E; e++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			
			edges[e] = new int[] {from, to, weight};
		}
		// 람다식으로 표현
		Arrays.sort(edges, (o1, o2) -> Integer.compare(o1[2], o2[2]));
		make();
		int result = 0, cnt = 0;
		for(int[] edge: edges) {
			if(union(edge[0], edge[1])) {
				result += edge[2];
				if(++cnt == N-1) break;
			}
		}
		System.out.println(result);
		sc.close();
	}
}
