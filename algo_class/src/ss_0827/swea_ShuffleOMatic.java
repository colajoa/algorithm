package ss_0827;

import java.util.*;
import java.io.*;

public class swea_ShuffleOMatic {
	static void dfs(int depth, Integer[] cards) {
		// 처음부터 같으면 min 갱신
		
		if(min <= depth || depth > 5) {
			return;
		}
		
		if(Arrays.equals(cardSort, cards) || Arrays.equals(cardReverse, cards)) {
			min = Math.min(min, depth);
			return;
		}
		
		Integer[][] dividedCards = divideCard(cards);
			
		for(int i=0; i<N; i++) {
			dfs(depth+1, shuffle(i, dividedCards[0], dividedCards[1]));
		}
	}
	
	
	static Integer[][] divideCard(Integer[] cards){
		Integer[][] dividedCards= new Integer[2][N/2];
		
		for(int i=0; i<N; i++) {
			dividedCards[i/(N/2)][i%(N/2)] = cards[i];
		}
		
		return dividedCards;
	}
	static Integer[] shuffle(int x, Integer[] left, Integer[] right) {
		Integer[] shuffledCard = new Integer[N];
		
		int leftIndex = x;
		int rightIndex = N/2;
		
		for(int i=0; i<N; i++) {
			
			if(leftIndex - x >= N/2) {
				shuffledCard[i] = right[rightIndex - N/2];
				rightIndex +=1 ;
				continue;
			}
			
			if(rightIndex - N/2 >= N/2) {
				shuffledCard[i] = left[leftIndex - x];
				leftIndex += 1;
				continue;
			}
			
			if(leftIndex >= rightIndex) {
				shuffledCard[i] = right[rightIndex - N/2];
				rightIndex += 1;
			}
			else {
				shuffledCard[i] = left[leftIndex - x];
				leftIndex += 1;
			}
		}
		
		return shuffledCard;
	}
	static int N, min;
	static boolean[] isSelected;
	static Integer[] cards;
	static Integer[] cardSort;
	static Integer[] cardReverse;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			cards = new Integer[N];
			cardSort = new Integer[N];
			cardReverse = new Integer[N];
			isSelected = new boolean[N];
			min = Integer.MAX_VALUE;
			token = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++) {
				cards[i] = Integer.parseInt(token.nextToken());
			}
			
			cardSort = Arrays.copyOf(cards, N);
			cardReverse = Arrays.copyOf(cards, N);
			
			Arrays.sort(cardSort);
			Arrays.sort(cardReverse, Comparator.reverseOrder());
			
			dfs(0, cards);
			if(min == Integer.MAX_VALUE) {
				sb.append("#").append(t).append(" ").append(-1).append("\n");
			}
			else {
				sb.append("#").append(t).append(" ").append(min).append("\n");
			}
		}
		System.out.println(sb);
	}
}
