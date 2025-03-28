import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11399_ATM {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		String[] input = br.readLine().split(" ");
		int idx = 0;
		for(String s: input) {
			if (idx==n) break;
			arr[idx++] = Integer.parseInt(s);
		}
		
		Arrays.sort(arr);
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			int sum = 0;
			for(int j=0; j<=i; j++) {
				sum += arr[j];
			}
			ans += sum;
		}
			
		System.out.println(ans);
		
	}
}
