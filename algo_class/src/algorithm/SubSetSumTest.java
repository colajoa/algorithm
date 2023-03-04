package algorithm;

import java.util.Scanner;

//n개의 자연수를 입력 받고 가능한 목표합이 주어지면 목표합에 해당하는 부분집합을 출력
public class SubSetSumTest {
	static int N, S, totalCnt;
	static int[] input;
	static boolean[] isSelected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		
		totalCnt = 0;
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		subset(0,0);
		System.out.println("총 경우의수 : "+ totalCnt);
	}
	
	static void subset(int index, int sum) {//index:부분집합에 고려할 대상 원소의 인덱스
		//기저 조건
		if(sum == S) {
			totalCnt++;
			for(int i =0; i<N; i++) {
				if(isSelected[i]) System.out.print(input[i]+"\t");
			}
			System.out.println();
			return;			
		}
		
		// sum > S
		if(sum > S || index == N) return ;
		
		// sum < S
		//유도
		//원소 선택
		isSelected[index] = true;
		subset(index+1, sum+input[index]);
		//원소 미선택
		isSelected[index] = false;
		subset(index+1, sum);
	}
}
