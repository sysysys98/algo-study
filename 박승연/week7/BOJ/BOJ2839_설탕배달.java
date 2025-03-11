import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839_설탕배달 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int five = n/5+1;
		int three = n/3+1;
		int ans = Integer.MAX_VALUE;
		boolean find = false;
		
		for(int i=five; i>=0; i--) {
			for(int j=three; j>=0; j--) {
				if(i*5+j*3==n) {
					ans = Math.min(ans, i+j); 
					find = true;
				}
			}
		}

		if(find) System.out.println(ans);
		else System.out.println(-1);
		
		//42인 경우 답이 10이 나와야 함
	}
}
