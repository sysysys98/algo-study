package 백준;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class boj1931 {
	//회의실 배정
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();
		
		int[][] time = new int[N][2];
		
		for(int i =0; i<N; i++) {
			time[i][0]=sc.nextInt();
			time[i][1]=sc.nextInt();
		}
		
		Arrays.sort(time,(int[] a,int[] b)->{	
			if(a[1]==b[1])
				return a[0]-b[0];
			else
				return a[1]-b[1];
		});
		
//		Arrays.sort(time, new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] a, int[] b) {
//				if(a[1]==b[1])
//					return a[0]-b[0];
//				else
//					return a[1]-b[1];
//			}
//		});
		
		int cnt =0;
		int end=0;
		for(int i=0; i<N;i++) {
			if(time[i][0]>=end) {
				end=time[i][1];
				cnt++;
			}else {
				continue;
			}
			
		}
		
		System.out.println(cnt);
	}

}
