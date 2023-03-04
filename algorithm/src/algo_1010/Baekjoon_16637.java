package algo_1010;
import java.io.*;
import java.util.*;

// 계산과 탐색을 따로 분리.
public class Baekjoon_16637 {
	static int ans;
	static int N;
	static List<Integer> nums = new ArrayList<>();
	static List<Character> op = new ArrayList<>();
	
	static void dfs(int depth, int sum) {
		if(op.size() <= depth) {
			ans = Math.max(ans, sum);
			return;
		}
		
		dfs(depth+1, calc(sum, nums.get(depth+1), op.get(depth)));
		
		if(depth+1 < op.size()) {
			dfs(depth+2, calc(sum,calc(nums.get(depth+1),nums.get(depth+2) , op.get(depth+1)), op.get(depth)));
		}
	}
	
	static int calc(int sum, int num, int op) {
		if(op == '+') {
			return sum + num;
		}
		else if(op == '-') {
			return sum - num;
		}
		else {
			return sum * num;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ans = Integer.MIN_VALUE;
		String str = br.readLine();
		for(int i=0; i<N; i++) {
			if(i%2==0) {
				int n = str.charAt(i)- '0';
				nums.add(n);
			}
			else {
				op.add(str.charAt(i));
			}
		}
		
		dfs(0, nums.get(0));
		System.out.println(ans);
	}
}
