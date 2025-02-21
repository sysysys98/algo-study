import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ2851 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int sum = 0;		
		for(int i=0; i<10; i++) {
			int input = Integer.parseInt(br.readLine());
			if(sum + input >= 100) {
//				int a = 100-sum;
//				int b = 100-sum-input;				
				if (200 < sum*2+input) {
					System.out.println(sum);
				} else {
					System.out.println(sum+input);
				}
				return;
			}
			sum += input;
		}
		System.out.println(sum);
	}
}
