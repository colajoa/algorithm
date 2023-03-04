package algo_0823;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import algo_0823.swea_3124_Kruskal.Edge;

// 프림 알고리즘
public class swea_3124_Prim {
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// return Integer.compare(this.weight, o.weight);
			return this.weight - o.weight;
		}

	}

	static void make() {
		parents = new int[V + 1];
		for (int v = 1; v <= V; v++) {
			parents[v] = v;
		}
	}

	static int find(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	static int V, E;
	static Edge[] edgeLi;
	static PriorityQueue<Edge> q;
	static int[] parents;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			token = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(token.nextToken());
			E = Integer.parseInt(token.nextToken());
			visited = new boolean[V];
			edgeList = new Edge[E];
			q = new PriorityQueue<>();
			for (int i = 0; i < E; i++) {
				token = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(token.nextToken());
				int to = Integer.parseInt(token.nextToken());
				int weight = Integer.parseInt(token.nextToken());

				q.add(new Edge(from, to, weight));
			}

			make();

			long ans = 0; //
			int cnt = 0;
			while (cnt < V - 1) {
				Edge now = q.poll();
				if (union(now.from, now.to)) {
					ans += now.weight;
					cnt++;
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		bw.write(sb.toString());
		bw.close();
	}
}
