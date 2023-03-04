package ss_0827;

import java.io.*;
import java.util.*;

public class swea_낚시터 {

	static class Gate {
		int gateNum;
		int fisher;

		public Gate(int gateNum, int fisher) {
			super();
			this.gateNum = gateNum;
			this.fisher = fisher;
		}

	}

	static int N, min, fisherCnt;
	static Gate[] gates;
	static int[] fishing;
	static boolean[] isSelected;

	static void perm(int depth, int dis) {
		if (dis >= min)
			return;
		if (depth == 3) {
			min = Math.min(dis, min);
		}

		for (int i = 1; i < 4; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			perm(depth + 1, dis + in(i, gates[i].fisher, true));
			out(i);

			if (gates[i].fisher % 2 == 0) {
				perm(depth + 1, dis + in(i, gates[i].fisher, false));
				out(i);
			}

			isSelected[i] = false;
		}
	}

	static int in(int i, int fisher, boolean odd) {
		int distance = 0;
		fisherCnt = 0;
		int sum = 0;
		
		while(fisherCnt < fisher) {
			
			sum += odd ? left(i, distance) : right(i, distance);
			
			if(fisherCnt == fisher) break;
			
			sum += odd ? right(i, distance) : left(i, distance);
			distance += 1;
		}
		
		return sum;
	}

	static void out(int i) {
		
		for(int j=1; j<=N; j++) {
			if(fishing[j] == i) 
				fishing[j] = 0;
		}
		
 	}
	
	static int left(int i, int distance) {
		int left = gates[i].gateNum - distance; 
		
		if(left > 0 && fishing[left] == 0) {
			fishing[left] = i;
			fisherCnt += 1;
			return distance + 1;
		}
		
		return 0;
	}
	
	static int right(int i, int distance) {
		int right = gates[i].gateNum + distance;
		
		if(right <= N && fishing[right] == 0) {
			fishing[right] = i;
			fisherCnt += 1;
			return distance + 1;
		}
		return 0;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			// 낚시터 게이트에서 나온 사람을
			fishing = new int[N + 1];

			// 기다리는 출입구, 사람 수
			gates = new Gate[4];

			// 게이트 선택을 위한 배열
			isSelected = new boolean[4];

			// 게이트 선택 순서

			for (int i = 1; i < 4; i++) {
				token = new StringTokenizer(br.readLine(), " ");
				gates[i] = new Gate(Integer.parseInt(token.nextToken()), Integer.parseInt(token.nextToken()));
			}
			
			perm(0, 0);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}	
}
