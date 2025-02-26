package pratice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ2583 {
	static boolean[][] map;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int m,n;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		
		//세로 m, 가로 n
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken()); //직사각형 개수

		
		map = new boolean[m][n];
		
		//m(y)=5 n(x)=7
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken());//왼쪽 아래 0
			int y1 = m-Integer.parseInt(st.nextToken()); // 5-2=3
			int x2 = Integer.parseInt(st.nextToken());//오른쪽 위 4
			int y2 = m-Integer.parseInt(st.nextToken()); // 5-4=1
			
			for(int b=y2; b<y1; b++) {
				for(int a=x1; a<x2; a++) {
					map[b][a] = true;
//					System.out.println("세로: "+b+" 가로: "+a);
				}
			}					
		} //다 칠하면
		
//		for(int i=0; i<m; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
				
		List<Integer> lst = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(!map[i][j]) {
					lst.add(DFS(i,j));
				}
			}
		}
		
		System.out.println(lst.size());
		Collections.sort(lst);
		for(int i=0; i<lst.size(); i++) {
			sb.append(lst.get(i)).append(" ");
		}
		System.out.println(sb);
	
	
	}
	
	static int DFS(int x, int y) {
		int cnt = 1;
		map[x][y] = true;

		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx >= 0 && nx < m && ny >= 0 && ny<n && !map[nx][ny]) {
				cnt += DFS(nx,ny);						
			}
		}
		
		return cnt;
	}
	

}
