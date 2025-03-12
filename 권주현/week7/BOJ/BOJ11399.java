import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//ATM퀴즈
public class BOJ11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for(int i =0; i<N;i++) {
			list.add(sc.nextInt());
		}
		
		Collections.sort(list); 
		int sum=0;
		int ans =0;
		for(int i =0;i<N;i++) {
			int temp =list.get(i);
			sum=temp+sum;//해당 번호 사람 시간 계산:sum
			ans+=sum; //합 갱신
		}
		System.out.println(ans);
		
	}
}
