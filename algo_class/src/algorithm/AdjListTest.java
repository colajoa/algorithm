package algorithm;

import java.util.Scanner;

public class AdjListTest {
	static int N;
	static boolean[] visited;
	static Node[] adjList;
	
	static class Node {
		int to; // from은 필요 없다. 헤드가 from
		Node next;
		
		public Node(int to, Node next) {
			super();
			this.to = to;
			this.next = next;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		
		adjList = new Node[N];
		visited = new boolean[N];
		for(int i =0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			// 헤드에 넣는다.
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]); 
		}
		
		dfs(0);
		
	}

	private static void dfs(int cur) {
		visited[cur] = true;
		System.out.print((char)(cur + 'A')+" ");
		for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
			if (!visited[temp.to]) { // 방문하지 않았으며 인접한 경우
				dfs(temp.to);
			}
		}
	}
}
