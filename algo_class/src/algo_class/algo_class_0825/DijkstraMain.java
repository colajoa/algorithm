package algo_class_0825;

import java.util.*;
import java.io.*;

public class DijkstraMain {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] g = new int[N][N];
		boolean[] v = new boolean[N];
		int[] dist = new int[N]; // 다익스트라
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				g[i][j] = sc.nextInt();
			}
			dist[i] = Integer.MAX_VALUE; // min값들을 MAX값으로 초기화
		}


		dist[0] = 0; // 0번부터 정점을 만들어감
		System.out.println(Arrays.toString(dist));System.out.println();
		for (int i = 0; i < N; i++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < N; j++) {
				if (!v[j] && min > dist[j]) {
					minVertex = j;
					min = dist[j];
				}
			}
			
			v[minVertex] = true;
			System.out.println("minVertex "+ minVertex);
			System.out.println("min "+min);
			System.out.println(Arrays.toString(v));
			System.out.println("result ");
			if (minVertex == - 1)
				break;
			
			for(int j=0; j<N; j++) {
				if(!v[j] && g[minVertex][j] != 0 && dist[j] >min + g[minVertex][j]) {
					dist[j] = min + g[minVertex][j];
				}
			}
			System.out.println(Arrays.toString(dist));
			System.out.println();
		}
		System.out.println(dist[N-1]);
		sc.close();
	}
}

/*============= 인접행렬 테스트케이스 

5
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0

output==> 8


6
0 3 5 0 0 0
0 0 2 6 0 0
0 1 0 4 6 0
0 0 0 0 2 3
3 0 0 0 0 6
0 0 0 0 0 0

output==> 12


10
0 4 6 0 0 0 0 0 0 0
0 0 0 9 8 0 0 0 0 0
0 3 0 0 2 3 0 0 0 0
0 0 0 0 0 0 6 0 0 0
0 0 0 2 0 1 3 7 0 0 
0 0 0 0 0 0 0 4 8 0
0 0 0 0 0 0 0 0 0 13
0 0 0 0 0 0 0 0 0 9
0 0 0 0 0 0 0 0 0 4
0 0 0 0 0 0 0 0 0 0


output ==> 21

============= 인접리스트 테스트케이스 
10 17
0 1 4
0 2 6
1 3 9
1 4 8
2 1 3
2 4 2
2 5 3
3 6 6
4 3 2
4 5 1
4 6 3
4 7 7
5 7 4
5 8 8
6 9 13
7 9 9
8 9 4

output ==> 21*/