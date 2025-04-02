package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj7576 {
	//토마토
	
	static int M;
	static int N;
	
	static int[][] map;
	static boolean[][] visited;
	
	static Queue<Coor> q;
	
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int day;
	static class Coor{
		int x, y;

		public Coor(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M=sc.nextInt();
		N=sc.nextInt();
		
		map = new int[N][M];
		visited= new boolean[N][M];
		q=new LinkedList<>();
		boolean all =true;
		for(int i =0; i<N;i++) {
			for(int j =0;j<M;j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==0 || map[i][j]==-1) all =false;
				if(map[i][j]==1) {
					q.add(new Coor(i,j));
					visited[i][j] =true;
				}
			}
		}
		day=0;
		bfs();
		boolean even =true;
		for(int i =0; i<N;i++) {
			for(int j =0;j<M;j++) {
				if(map[i][j]==0) {
					even =false;
					break;
				}
			}
		}
		
		if(all) {
			System.out.println(0);
		}else {
			if(!even) {
				System.out.println(-1);
			}else {
				System.out.println(day-1);
			}
		}
		
		
	}


	static void bfs() {
		while(!q.isEmpty()) {
			int size =q.size();
			for(int i=0; i<size;i++) {
				Coor curr =q.poll();
				int r =curr.x;
				int c =curr.y;
				for(int d =0; d<4;d++) {
					int nr =r+dr[d];
					int nc =c+dc[d];
					
					if(nr<0 ||nc<0||nr>=N||nc>=M) continue;
					if(map[nr][nc]==-1||visited[nr][nc])continue;
					map[nr][nc]=1;
					visited[nr][nc]=true;
					q.add(new Coor(nr,nc));
					
					
				}
			}
			day++;
			
		}
		
	}
}
