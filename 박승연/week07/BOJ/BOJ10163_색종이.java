import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10163_색종이 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[1001][1001];
		int[] paper = new int[n+1];
		
		StringTokenizer st;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());;
			int y = Integer.parseInt(st.nextToken());;
			int w = Integer.parseInt(st.nextToken());;
			int h = Integer.parseInt(st.nextToken());;
			
			for(int j=x; j<x+w && j<=1000; j++) {
				for(int k=y; k<y+h && k<=1000; k++) {
					map[j][k] = i;
				}
			}
		}
		
		for(int i=0; i<1001; i++) {
			for(int j=0; j<1001; j++) {
				if(map[i][j]!=0) paper[map[i][j]]++;				
			}
		}
		
		for(int i=1; i<=n; i++) {
			sb.append(paper[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}
