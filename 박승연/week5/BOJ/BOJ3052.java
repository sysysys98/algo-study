import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3052 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] rem = new int[42]; //42로 나눈 나머지는 0~41뿐
		int ans = 0;
		
		for(int i=0; i<10; i++) {
			int input = Integer.parseInt(br.readLine())%42;
			if (rem[input]++==0) { //만일 한번도 안 나온 나머지면
				ans++;
			}		
		}
		
		System.out.println(ans);
	}
}
