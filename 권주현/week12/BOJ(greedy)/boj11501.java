package 백준;

import java.util.Scanner;

public class boj11501 {
	
	//주식
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T =sc.nextInt();
		
		for(int tc= 1; tc<=T;tc++) {
			int N=sc.nextInt();
			
			long[] arr =new long[N];
			
			for(int i=0;i<N;i++) {
				arr[i]=sc.nextLong();
			}
			
			long sum =0;
			long max =0;
			for(int i=N-1; i>=0;i--) {
				if(arr[i]>max) {
					max=arr[i];
				}else {
					sum+=max-arr[i];
				}
			}
			
			System.out.println(sum);
			
			
		}
		
	}
}
