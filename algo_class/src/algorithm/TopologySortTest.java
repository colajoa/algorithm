package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologySortTest {
	static class Node {
		int vertext;
		Node next;

		public Node(int vertext, Node next) {
			super();
			this.vertext = vertext;
			this.next = next;
		}
	}
	static int V, E;
	static Node[] adjList;
	static int[] inDegree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(token.nextToken());
		E = Integer.parseInt(token.nextToken());

		adjList = new Node[V+1]; // 각 정점별 인접리스트
		inDegree = new int[V+1]; // 정점별 진입차수
		
		for (int i = 0; i < E; i++) {
			token = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(token.nextToken());
			int to = Integer.parseInt(token.nextToken());

			// 유향처리
			adjList[from] = new Node(to, adjList[from]);
			inDegree[to]++;
		}
		ArrayList<Integer> list = topologySort();
		
		if(list.size()==V) {
			System.out.println(list);
		}
		else {
			System.out.println("cycle");
		}
	}
	
	static ArrayList<Integer> topologySort(){
		ArrayList<Integer> list = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		// 진입차수가 0인 정점 큐에 넣기
		for(int i=1; i<V+1; i++) {
			if(inDegree[i]==0) queue.offer(i);
		}
		
		//BFS
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			// 처리 순서
			list.add(cur);
			// 
			for(Node temp = adjList[cur]; temp != null; temp = temp.next) {
				// 인접 리스트의 진입차수를 1줄여서 0이면 큐에 담기
				if(--inDegree[temp.vertext]==0) queue.offer(temp.vertext);
			}
		}
		return list;
	}
}
