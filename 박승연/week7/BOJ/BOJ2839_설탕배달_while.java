import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839_설탕배달_while {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		while(n%5!=0 && n>=0) {
			n -= 3;
			cnt++;
		}

		if(n<0) System.out.println(-1);
		else System.out.println(cnt + n/5);
		
		//42인 경우 답이 10이 나와야 함
	}
}