package algorithm;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class graphTest {
	static class Node {
		
		int vertex;
		Node next;
		
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
		
		
	}
	
	static int V;
	static Node[] adjList;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		int E = sc.nextInt();
		
		adjList = new Node[V];
		
		for(int i=0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
			
			
		}
		System.out.println("==========dfs==========");
		visited = new boolean[V];
		dfs(0);
		System.out.println("==========bfs==========");
		bfs();
	}
	
	static void dfs(int cur) {
		visited[cur] = true;
		System.out.println(cur);
		for(Node temp = adjList[cur]; temp != null; temp= temp.next) {
			if(!visited[temp.vertex]) {
				dfs(temp.vertex);
			}
		}
	}
	
	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[V];

		q.add(0);
		visited[0] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.println(cur);
			
			for(Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if(!visited[temp.vertex]) {
					visited[temp.vertex] = true;
					q.add(temp.vertex);
				}
			}
		}
	}
}

/*
7
8
0 1
0 2
1 3
1 4
3 5
4 5
5 6
2 6
*/
