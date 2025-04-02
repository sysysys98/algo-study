package 백준;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//단지 번호 붙이기
public class boj2667 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int sum;
	
	static int[] dr = {-1,1,0,0}; 
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N =sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		
		sc.nextLine();
		for(int i =0; i<N; i++) {
			String str =sc.next();
			for(int j =0; j<N; j++) {
				map[i][j] =str.charAt(j)-'0';
			}
		}
		List<Integer> list = new ArrayList<>();
		int cnt =0;
		for(int i =0; i<N;i++) {
			for(int j =0; j<N;j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					sum =0;
					dfs(i,j);
					list.add(sum);
					cnt++;
				}
			}
		}
		Collections.sort(list);
		System.out.println(cnt);
		for(int i=0; i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		
	}
	private static  void dfs(int i, int j) {
		visited[i][j] =true;
		sum++;
		for(int d =0; d<4; d++) {
			int nr = i +dr[d];
			int nc = j +dc[d];
			
			if(nr<0 || nc<0 || nr>=N || nc >=N) continue;
			if(map[nr][nc] ==0) continue;
			if(visited[nr][nc]) continue;
			dfs(nr,nc);
			
		}
		
	
	}

}
