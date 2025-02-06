//BOJ 2563. 색종이(실버 5)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[][] paper = new boolean[100][100];
		int ans = 0;
		
		int n = Integer.parseInt(br.readLine());
		int x,y;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			for(int j=x-1; j<x+9 && j<100; j++) {
				for (int k=y-1; k<y+9 && k<100 ; k++) {
					if (!paper[j][k]) {
						paper[j][k] = true;
						ans++;
					}
				}
			}
		}
		
		System.out.println(ans);	
	}
}
