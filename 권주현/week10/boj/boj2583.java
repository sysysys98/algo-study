package 백준;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj2583 {
//영역 구하기
	
	static int M;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int extent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M =sc.nextInt();
		N =sc.nextInt();
		int K =sc.nextInt();
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i =0; i<K;i++) {
			int sr=sc.nextInt();
			int sco=sc.nextInt();
			int er=sc.nextInt();
			int eco=sc.nextInt();
			
			for(int a =sco;a<eco;a++) {
				for(int b =sr;b<er;b++) {
					map[a][b]=1;
					visited[a][b] =true;
				}
			}
		}
		int cnt=0;
		List<Integer> list =new ArrayList<>();
		for(int i =0 ;i<M;i++) {
			for(int j =0; j<N;j++) {
				if(map[i][j]==0 && !visited[i][j]) {
					extent=0;
					dfs(i,j);
					list.add(extent);
					cnt++;
				}
			}
			
		}
		System.out.println(cnt);
		Collections.sort(list);
		for(int i =0 ;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		
	}

	static void dfs(int i, int j) {
		visited[i][j] =true;
		extent++;
		for(int d=0;d<4;d++) {
			int nr = i+dr[d];
			int nc = j+dc[d];
			
			if(nr<0 || nc<0 || nr>=M ||nc>=N) continue;
			if(map[nr][nc]==1 || visited[nr][nc])continue;
			
			dfs(nr,nc);
		}
		
		
		
		
	}
}
