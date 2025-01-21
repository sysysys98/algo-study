import java.util.Scanner;

//S가 나올때 +1씩 L이 나오는 경우 L의 개수를 다 세서 2로 나누고 +1 해서 합산해서 계산합니다.
//*LL*LL* -> 4/2+1=3, *LL*LL*LL* -> 6/2+1=4
//S의 경우 양 옆자리에 컵홀더가 존재하므로 고려할 필요X
//입력된 문자열에 L이 0개인 경우 S의 개수만 계산해서 출력하게끔 구현하였습니다.
public class Cupholder {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		sc.nextLine();
		String result = sc.nextLine();
		int s_cnt =0;
		int l_cnt =0;
		int ans=0;
		for(int i =0;i<n;i++) {
			if(result.charAt(i)=='S') {
				s_cnt++;
			}
			if(result.charAt(i)=='L') {
				l_cnt++;
			}
		}
		if(l_cnt==0) {
			ans = s_cnt;
		}else {
			ans =s_cnt +l_cnt/2+1;
		}
		
		System.out.println(ans);
	}
}
