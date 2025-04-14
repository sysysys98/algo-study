package 백준;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BOJ1026 {
	//보물
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();
		
		List<Integer> A =new ArrayList<>();
		List<Integer> B =new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			A.add(sc.nextInt());
		}
		for(int i=0;i<N;i++) {
			B.add(sc.nextInt());
		}
		Collections.sort(A);
		Collections.sort(B,Comparator.reverseOrder());
		
		int sum=0;
		
		for(int i=0; i<N;i++) {
			sum+=A.get(i)*B.get(i);
		}
		
		System.out.println(sum);
	}

}
