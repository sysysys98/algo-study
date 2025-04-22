package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182_부분수열의합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, s;
	static int cnt = 0;
	static int[] nums;
	static boolean[] vst;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		nums = new int[n];
		vst = new boolean[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		backtracking(0,0);
		
		System.out.println(cnt);
	}
	
	public static void backtracking(int sum, int idx) {
		if(idx>=n) return;
		
		if(!vst[idx]) {
			if(sum+nums[idx]==s) {
				cnt++;
			}
		}

		vst[idx] = true;
		backtracking(sum+nums[idx], idx+1);
		vst[idx] = false;
		backtracking(sum, idx+1);
			
		
	}
}
