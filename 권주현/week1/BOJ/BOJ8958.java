import java.util.Scanner;


//문자열에서 각 문자마다 O가 나오면 next++후 score에 더하고 X가 나오는 경우 next=0으로 초기화하면서 점수를 계산합니다.
public class OXquiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case = sc.nextInt();
		sc.nextLine();
		
		for(int i=1;i<=test_case;i++) {
			String result =sc.nextLine();
			int score =0;
			int next =0;
			for(int j =0; j<result.length();j++) {
				if(result.charAt(j)=='O') {
					next++;
		
				}else {
					next=0;
				}
				score+=next;
			}
			
			System.out.println(score);
			
		}
		sc.close();
	}
}
