import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1780_종이의개수 {
	static int[][] map;
	static int[] paper = new int[3]; //-1, 0, 1
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		StringTokenizer st;
		int size = n;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(size, 0, 0);		
		
		for(int i=0; i<paper.length; i++) {
			System.out.println(paper[i]);
		}
	}
	
	static void dfs(int size, int r, int c) {	
		if(isSame(size, r,c)) {
			paper[map[r][c]+1]++;
			return;
		}

		int ns = size/3; //next size

		for(int k=r; k<r+size; k+=ns) {
			for(int l=c; l<c+size; l+=ns) {
				dfs(ns, k, l);
			}
		}
	}

	static boolean isSame(int size, int r, int c) {
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(map[i][j] != map[r][c]) {
					return false;
				}
			}
		}
		return true;
	}
}
