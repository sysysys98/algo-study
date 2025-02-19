import java.util.Scanner;
//비밀이메일
public class BOJ2999 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String str =sc.nextLine();
	int N =str.length();
	int r =-2;
	int c =-1;
	for(int i =1; i<=N;i++) {
		if(N%i==0) {
			if(r>=c) break;
			r = i;
			c = N/r;
			
		}
	}	
	Character[][] arr = new Character[c][r];  //행렬생성
	for(int i =0; i<r;i++) { //행렬채우기 열고정
		for(int j =0;j<c;j++) {
			arr[j][i] =str.charAt(i*c+j);
		}
	}
	for(int i =0; i<c;i++) {
		for(int j =0;j<r;j++) {
			System.out.print(arr[i][j]);
		}
	}
	
	
}
}
