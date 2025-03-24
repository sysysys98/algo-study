import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ12865_평범한배낭 {
	
	public static class Item{
		int w, v; //무게, 가치

		public Item(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}		
	}
	
	public static int n, k;
	public static List<Item> lst = new ArrayList<>();
	public static int [][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		dp = new int[n+1][k+1];
		dp[0][0] = 0;
		
		lst.add(new Item(0,0));
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			lst.add(new Item(w,v));
		}
		
		dping(k);
		
		System.out.println(dp[n][k]);
		
	}
	
	public static void dping(int k) {
		for(int i=1; i<=k; i++) {
			for(int j=1; j<=n; j++) {
				if(lst.get(j).w>i) {
					dp[j][i] = dp[j-1][i];
				} else {
					dp[j][i] = Math.max(dp[j-1][i-lst.get(j).w]+lst.get(j).v, dp[j-1][i]);
				}
			}
		}
	}
}
