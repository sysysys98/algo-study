import java.util.Scanner;

public class BOJ2839 {
	//설탕배달
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int cnt =0;
		
		//greedy 알고리즘 
		if(N%5==0) {
			cnt+=N/5;  //5로 나누어떨어지는 경우
		}else {
			int tmp = N/5;  //5로 나눈 몫
			for(int i= tmp;i>=0;i--) { //몫을 0까지 1씩 줄면서 for문
				int remain =N- i*5; //나머지 계산
				if(remain%3==0) { //나머지 3으로 떨어지면
					cnt+= i+remain/3; //개수 계산
					break;
				}
			}	
		}
		if(cnt==0) { //못만드는 경우
			System.out.println(-1);
		}else {
			System.out.println(cnt);
		}
		
	}
}
