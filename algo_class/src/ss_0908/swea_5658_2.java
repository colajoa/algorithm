package ss_0908;

import java.io.*;
import java.util.*;

// 상자를 돌린다. 큐브를 돌린다.시계 방향
public class swea_5658_2 {
	// 입력 길이, K번째 수
	static int N, K;
	// 박스 윗부분, 박스 아랫부분 큐
	static List<String> upBox = new ArrayList<>();
	static List<String> downBox = new ArrayList<>();
	// 그냥 리스트나 배열 받아서 중복체크해도 될거 같다.
	// Set은 중복을 허용하지 않고 TreeSet은 오름차순 정렬을 하므로 내림차순으로 정렬로 바꿔준다.
	static Set<Integer> nums = new TreeSet<>((o1,o2) -> -Integer.compare(o1, o2));
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = null;
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 갯수
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			token = new StringTokenizer(br.readLine()," ");
			// 숫자 입력 길이
			N = Integer.parseInt(token.nextToken());
			// 찾을 순서 
			K = Integer.parseInt(token.nextToken());
			
			// N개의 16진수 
			String[] str = br.readLine().split("");
			
			// 입력 받은 숫자 반으로 나눠서 처음부터 반만큼 upBox에 저장
			for(int i=0; i < N/2; i++) {
				 upBox.add(str[i]);
			}
			
			// 남은 반은 뒤에서부터 downBox에 저장
			for(int i=N-1; i>=N/2; i--) {
				downBox.add(str[i]);
			}
			//System.out.println(upBox);
			//System.out.println(downBox);
			
			// 돌린 횟수
			int cnt = 0;
			
			// cnt가 N/4 한변의 갯수만큼 돌면 다시 처음 순서와 같아지기 때문에 cnt가 N/4만큼될때까지 반복
			while(cnt != N/4) {
				
				// hex 길이 = N/4만큼 저장
				int len = 0;
				
				// hex를 저장하기 위한 변수
				String hex = "";
				
				// 리스트 순서대로 hex에 추가하면서 한변의 길이를 만족하면 nums Set에 저장후, 사용한 변수들 초기화.
				for(int i= 0; i < N/2; i++) {
					hex += upBox.get(i);
					len += 1;
					if(len == N/4) {
						nums.add(Integer.parseInt(hex, 16));
						hex = "";
						len = 0;
					}
				}
				
				// 리스트 역순서대로 hex에 추가하면서 한변의 길이를 만족하면 nums Set에 저장후, 사용한 변수들 초기화.
				for(int i= N/2 - 1; i >= 0; i--) {
					hex += downBox.get(i);
					len += 1;
					if(len == N/4) {
						nums.add(Integer.parseInt(hex, 16));
						hex = "";
						len = 0;
					}
				}
				
				// 위에서 꺼내서 밑으로 넣을 원소
				String upTmp = upBox.remove(upBox.size()-1);
				// 밑에서 꺼내서 위로 넣을 원소
				String downTmp = downBox.remove(0);
				
				// 위에는 맨 앞에 밑에는 맨 뒤에 넣어주면 된다.
				upBox.add(0, downTmp);
				downBox.add(upTmp);
				cnt += 1;
			}
			//System.out.println(nums);
			
			// K번 째에 있는 숫자를 출력하기 위한 ans와 K번 째인지 확인하기 위한 cnt
			int ans = 0;
			cnt = 0;
			for(Integer num : nums) {
				cnt+=1;
				if(cnt == K) {
					ans = num;
					// 써도되고 안써도되는데 속도가 안쓴게 젤빠름.
					break;
				}
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
			
			// 다음 테스트 케이스를 위해 저장된 정보 비우기
			upBox.clear();
			downBox.clear();
			nums.clear();
		}
		System.out.println(sb);
	}
}
