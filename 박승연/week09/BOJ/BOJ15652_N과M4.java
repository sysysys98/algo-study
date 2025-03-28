import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652_N과M4 {
	static StringBuilder sb = new StringBuilder();
	static StringBuilder tmp = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		
		수열(1, n, m, new StringBuilder());
		
		System.out.println(sb);
		
	}	
	
	public static void 수열(int now, int n, int m, StringBuilder tmp) {
		if(tmp.length()/2==m) {
			sb.append(tmp).append("\n");			
			return;
		}
		
		for(int i=now; i<=n; i++) {
			int len = tmp.length();
			tmp.append(i).append(" ");
			수열(i, n, m, tmp);			
			tmp.setLength(len);
		}				
	}
}
