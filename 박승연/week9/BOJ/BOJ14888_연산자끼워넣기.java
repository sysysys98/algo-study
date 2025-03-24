import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888_연산자끼워넣기 {
	static int[] opr = new int[4]; //연산자 (+ - * / )
	static int[] nums;
	static int n, max, min;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine()); //숫자 개수
		nums = new int[n];
				
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken()); //수열 받기
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			opr[i] = Integer.parseInt(st.nextToken());// 연산자 받기	
		}

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		backtracking(1, nums[0]);
		
		System.out.println(max);
		System.out.println(min);
		
	}
	
	//idx: 계산한 숫자 수 
	public static void backtracking(int idx, int sum) {
		if(idx==n) {
			max = Math.max(sum, max);
			min = Math.min(sum, min);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(opr[i] > 0) { //연산자 남아 있는지 확인
				opr[i]--;
				backtracking(idx+1, culc(sum, nums[idx], i));
				opr[i]++;
			}
		}
	}
	
	public static int culc(int a, int b, int op) {
		if(op==0) { //덧셈이 들어올 차례
			return a+b;
		} else if(op==1) { //뺄셈
			return a-b;
		} else if(op==2) { //곱셈
			return a*b;
		} else {
			return a/b;
		}
	}
}
