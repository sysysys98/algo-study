//BOJ 2999. 비밀 이메일(브론즈 1)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2999 {
	public static void main(String[] args) throws IOException{

//		먼저, 정인이는 R<=C이고, R*C=N인 R과 C를 고른다. 만약, 그러한 경우가 여러 개일 경우, R이 큰 값을 선택한다.
//		=>즉 R과 C가 서로 가장 근접한 값인 경우를 선택
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		String input = br.readLine();
		int l = input.length();
		int r = (int) Math.sqrt(l);
		int c = 0;
		if(r*r == l) { //제곱해서 l이 나오면 r=c
			c=r;
		} else {
			c = r+1; //아니면 c>r인 경우
		}
		
		while(l != r*c) {
			if (l > r*c) {
				c++;
			} else if(l < r*c) {
				r--;
			}
		}

		char[][] arr = new char[c][r];
		int idx = 0;
		for(int i=0; i<c; i++) {
			for(int j=0; j<r; j++){
				arr[i][j] = input.charAt(idx++);
			}
		}

		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++){
				sb.append(arr[j][i]);
			}
		}

		System.out.println(sb);
	}
	
}
