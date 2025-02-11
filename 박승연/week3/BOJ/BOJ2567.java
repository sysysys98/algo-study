//BOJ 2567. 색종이 - 2(실버 4)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2567 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[][] paper = new boolean[101][101];
		int[] dr = { 1, -1, 0, 0};
		int[] dc = { 0, 0, 1, -1};
		int ans = 0;
		
		int n = Integer.parseInt(br.readLine());
		int x,y;
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			for(int j=x; j<=x+9 && j<101; j++) {
				for (int k=y; k<=y+9 && k<101 ; k++) {
					if (!paper[j][k]) {
						paper[j][k] = true;
					}
				}
			}
		}
		
		for(int j=0; j<101; j++) {
			for (int k=0; k<101 ; k++) {
				if(paper[j][k]) {//자기자신이 true면서
					for(int d=0; d<4; d++) {
						int nr = j + dr[d];
                        int nc = k + dc[d];
                        //흰 색종이 경계에 닿아 있거나 주변에 칠해져 있지 않은 곳이 있는 경우 둘레에 해당
                        if (nr<0 || nr>100 || nc<0 || nc>100 || !paper[nr][nc]) {
                        	ans++;
                        }                         
					}
				}
				
			}
		}
		
		System.out.println(ans);	
	}
}
