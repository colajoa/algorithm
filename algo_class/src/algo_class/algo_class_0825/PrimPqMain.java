package algo_class_0825;

import java.util.*;
import java.io.*;

public class PrimPqMain {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] g = new int[N][N];
		boolean[] v = new boolean[N];
		int[] minEdge = new int[N]; // 프림
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				g[i][j] = sc.nextInt();
			}
			minEdge[i] = Integer.MAX_VALUE; // min값들을 MAX값으로 초기화
		}

		for (int[] b : g)
			System.out.println(Arrays.toString(b));
		System.out.println();

		int result = 0, cnt = 0;
		// 가중치를 중심으로 정렬
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
		minEdge[0] = 0; // 0번부터 정점을 만들어감
		
		pq.offer(new int[] {0,0}); // 정점, 가중치
		System.out.println(Arrays.toString(minEdge));System.out.println();
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int minVertex = cur[0];
			int min = cur[1];

			if(v[minVertex]) continue;
			
			v[minVertex] = true;
			result += min;
			System.out.println("minVertex "+ minVertex);
			System.out.println("min "+min);
			System.out.println(Arrays.toString(v));
			System.out.println("result "+result);
			if (cnt++ == N - 1)
				break;
			
			for(int j=0; j<N; j++) {
				if(!v[j] && g[minVertex][j] != 0 && minEdge[j] >g[minVertex][j]) {
					minEdge[j] = g[minVertex][j];
					pq.offer(new int[]{j, g[minVertex][j]});
				}
			}
			System.out.println(Arrays.toString(minEdge));
			System.out.println();
		}
		System.out.println(result);
		sc.close();
	}
}

/*
 * 5 0 5 10 8 7 5 0 5 3 6 10 5 0 1 3 8 3 1 0 1 7 6 3 1 0
 * 
 * output==>10
 * 
 * 7 0 32 31 0 0 60 51 32 0 21 0 0 0 0 31 21 0 0 46 0 25 0 0 0 0 34 18 0 0 0 46
 * 34 0 40 51 60 0 0 18 40 0 0 51 0 25 0 51 0 0
 * 
 * output==>175
 */