package ss_0827;

import java.util.*;
import java.io.*;
// 최종
// 초기화를 잘하자 !
// Math.abs보다 상하님처럼 *-1을 사용해보자
public class swea_헌터3 {
	static int N, all, min;
	// 몬스터 4 고객 4 몬스터
	// 몬스터 고객 
	// 1 : 1-2
	// 2 : 1-3 2-4
	// 3 : 1-4 2-5 3-6
	// 4 : 1-5 2-6 3-7 4-8
	static int[] selected;
	static boolean[] isSelected;
	
	static int[][] map;
	static int[][] monsterPoint;
	static int[][] clientPoint;
	static int[][] points;
	
	// 순열
	static void perm(int depth) {
		
		if(depth == all+1) {
			// 경로 값 저장
			int ans = 0;
			// 0번부터 이동하기 위해서 반복문 1부터 시작해서 all(몬스터+고객)까지
			for(int i=1; i<=all; i++) {
				// from -> to로 이동
				int from = selected[i-1];
				int to = selected[i];
				
				// 맨해튼 거리로 거리 계산
				ans += Math.abs(points[from][0] - points[to][0]) + Math.abs(points[from][1] - points[to][1]);
			}
			// 현재 최소 값과 경로 값을 비교
			min = Math.min(ans, min);
			return;
		}
		
		// 순열
		for(int i=1; i<all+1; i++) {
			
			// 선택되었으면 continue로 다음 반복
			if(isSelected[i]) continue;
			
			// 1~4는 몬스터 5~8은 고객이기때문에 몬스터를 잡지 않고 고객에게 갈수 없기때문에
			// 그런 경우는 빼주기 위한 조건 ex) -1 -2 -3 1 2 3처럼 몬스터를 잡지않고 방문을 할 수 없음.
			// i가 all/2보다 크고 몬스터를 잡지 않았다면 continue;
			if(i > all/2 && !isSelected[i-all/2]) continue;
			
			// 아니라면 순열
			
			// 번호 선택
			isSelected[i] = true;
			
			// 선택된 번호 저장
			selected[depth] = i;
			
			// 다음 숫자 뽑기
			perm(depth+1);
			
			// 다음 선택을 위한 false
			isSelected[i] = false;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 입력
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			// 입력 받는 맵의 크기
			N = Integer.parseInt(br.readLine());
			// 최소 값 변수
			min = Integer.MAX_VALUE;
			
			// 몬스터와 고객이 몇개 들어온다는 조건이 없어서 최대 값으로 배열을 만들어 줌 최대 4개니까 가능.
			// 몬스터와 고객을 합쳐서 많아봐야 8의 크기
			// 몬스터 위치 
			monsterPoint = new int[5][2];
			// 고객 위치
			clientPoint = new int[5][2];
			
			// 있어도 되고 없도됨 입력 받는 맵 초기화
			map = new int[N][N];
			
			// 몬스터와 고객의 총합
			all = 0;
			
			// 맵 입력
			for(int i=0; i<N; i++) {
				
				// 한줄씩 token으로 받아준다.
				token = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					
					// 1칸 씩 변수 a에 담아서 검사
					int a = Integer.parseInt(token.nextToken());
					
					// 몬스터면 monsterPoint배열 해당 번호에 좌표를 담는다.
					// 그리고 총합 증가.
					if(a > 0 ) {
						monsterPoint[a] = new int[] {i,j}; 
						all += 1;
						}
					
					// 고객도 마찬가지로 clientPoint배열 해당 번호에 좌표를 담고 총합을 증가시킨다.
					if(a < 0 ) {
						clientPoint[Math.abs(a)] = new int[] {i,j};
						all += 1;
					}
				}
			}
			
			// 뽑은 순서를 저장할 배열
			selected = new int[all+1];
			
			// 뽑았는지 확인하는 배열
			isSelected = new boolean[all+1];
			
			// 몬스터와 고객을 담기위한 배열
			points = new int[all+1][2];
			
			// 출발점이 1,1이기 때문에 0번째 배열에 [0,0]을 저장한다.
			points[0] = new int[] {0,0};
			
			// 1~4까지는 몬스터의 좌표를 저장 5~8까지는 고객의 좌표를 저장
			
			// 1~ all/2까지 monsterPoint 복사
			for(int i = 1; i<all/2+1; i++) {
				points[i] = Arrays.copyOf(monsterPoint[i], 2);
			}
			
			// all/2 ~ all까지 clientPoint 복사
			for(int i=all/2+1; i<all+1; i++) {
				points[i] = Arrays.copyOf(clientPoint[i-all/2], 2);
			}
			
			// 순열
			perm(1);
			
			// 정답 StringBuilder에 저장
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		// 정답 출력
		System.out.println(sb);
	}
}
