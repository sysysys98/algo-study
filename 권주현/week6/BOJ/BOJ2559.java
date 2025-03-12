package 시험대비;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ2559 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int K =sc.nextInt();
		
		int[] arr=new int[N];
		for(int i =0; i<N; i++) {
			arr[i] =sc.nextInt();
		}
		List<Integer> list = new ArrayList<>();
		
		
		for(int i =0;i<N-K+1;i++) {
			int sum =0;
			for(int j =0; j<K;j++) {
				sum+=arr[i+j];
			}
			list.add(sum);
		}
		Collections.sort(list);
		System.out.println(list.get(N-K));
	}
}
