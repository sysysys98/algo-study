package 백준;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj2217 {
	//로프
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();
		
		List<Integer> list  = new ArrayList<>();
		
		for(int i =0 ; i<N;i++) {
			list.add(sc.nextInt());
		}
		
		Collections.sort(list);
		int ans =0;
		
		for(int i =0;i<N;i++) {
			int tmp =list.get(i)*(N-i);
			ans=Math.max(ans, tmp);
		}
		System.out.println(ans);
	}

}
