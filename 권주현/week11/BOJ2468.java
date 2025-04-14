package 백준;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2468 {
  //안전영역
  static int N;
  static int[][] map;
  static boolean[][] visited;
  
  static int[] dr = {-1,0,1,0};
  static int[] dc = {0,1,0,-1};
  public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
	  N =sc.nextInt();
	  map = new int[N][N];
	  visited=new boolean[N][N];
	  
	  int maxh =0;
	  for(int i =0;i<N;i++) {
		  for(int j =0; j<N;j++) {
			  map[i][j]=sc.nextInt();
			  maxh =Math.max(maxh, map[i][j]);
		  }
	  }
	  
	  int area =0;
	  for(int rain =0 ;rain<maxh;rain++) {
		  int tmp =0;
		  for(int i =0;i<N;i++) {
			  for(int j =0;j<N;j++) {
				  if(map[i][j]>rain && !visited[i][j]) {
					  bfs(i,j,rain);
					  tmp++;
				  }
			  }
		  }
		  for(int k=0;k<N;k++) {
			  Arrays.fill(visited[k], false);
		  }
		  area =Math.max(area, tmp);
	  }
	  
	  
	  System.out.println(area);
	  
  }
  private static void bfs(int i, int j,int k) {
	  // TODO Auto-generated method stub
	  
	  Queue<int[]> q =new LinkedList<>();
	  q.add(new int[] {i,j});
	  visited[i][j]=true;
	  while(!q.isEmpty()) {
		  int[] curr = q.poll();
		  
		  for(int d =0;d<4;d++) {
			  int nr =curr[0]+dr[d];
			  int nc =curr[1]+dc[d];
			  
			  if(nr<0||nc<0||nr>=N ||nc>=N) continue;
			  if(map[nr][nc]<=k || visited[nr][nc]) continue;
			  
			  q.add(new int[] {nr,nc});
			  visited[nr][nc]=true;
		  }
	  }
	  
  }
}
