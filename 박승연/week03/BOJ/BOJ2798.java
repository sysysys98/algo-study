//BOJ 2798. 블랙잭(브론즈 2)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		//3장의 합이 m과 가장 가까운 경우의 수
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int tmp = 0;
		int dif = Integer.MAX_VALUE; //최소 차이를 구하기 위해 임시값은 최대값으로
		int ans = 0;
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				for (int k=j+1; k<n; k++) {
					tmp = arr[i]+arr[j]+arr[k]; //3개를 합했을 때
					if ( Math.abs(m-tmp) < dif && tmp <= m) { //m과의 차이 절대값이 최소이고 m을 넘지 않음
						ans = tmp;
						dif = Math.abs(m-tmp);						
					}
				}
			}
		}
		
		System.out.println(ans);
	}
}
