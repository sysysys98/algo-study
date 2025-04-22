package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SWEA1767_프로세서연결하기 {
	static Scanner sc = new Scanner(System.in); 
	static int tc, n;
	static int[][] map;
	static boolean[][] vst;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static List<int[]> lst;
	static List<Core> ans;
	static class Core implements Comparable<Core>{
		int len, on;

		public Core(int len, int on) {
			this.len = len;
			this.on = on;
		}

		@Override
		public int compareTo(Core o) {
			if (this.on<o.on) {
				return 1;
			} else if (this.on==o.on){
				return this.len-o.len;
			}
			return -1;
		}	
	}
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			n = sc.nextInt();
			map = new int[n][n];
			vst = new boolean[n][n];
			lst = new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 1 && (i==0 || i==n-1 || j==0 || j==n-1) ) {
						vst[i][j] = true; 
					}
					if (map[i][j] == 1 && !vst[i][j]) {
						lst.add(new int[] {i,j});
					}
				}				
			}			
			
			ans = new ArrayList<>();
			back(0,0,0);
			
			Collections.sort(ans);

			sb.append("#").append(t).append(" ").append(ans.get(0).len).append("\n");
			
		}
		System.out.println(sb);
	}

	public static void back(int sum, int idx, int coreOn) {
		if(idx==lst.size()) {
			ans.add(new Core(sum, coreOn));
			return;
		}
		
		int r = lst.get(idx)[0];
		int c = lst.get(idx)[1];
		
		for(int d=0; d<4; d++) {
			if(able(r,c,d)) {
				List<int[]> tmp = new ArrayList<>();
				vst[r][c]=true;
				int depth = 0;
				int nr = r+(dr[d]*(depth+1));
				int nc = c+(dc[d]*(depth+1));
				while (bound(nr,nc) && !vst[nr][nc] && map[nr][nc]==0) {
					tmp.add(new int[] {nr,nc});
					vst[nr][nc] = true;
					map[nr][nc] = 3;
					depth++;
					nr = r+(dr[d]*(depth+1));
					nc = c+(dc[d]*(depth+1));					
				}

				back(sum+depth, idx+1, coreOn+1);
				
				vst[r][c] = false;
				
				while (!tmp.isEmpty()) {
					vst[tmp.get(0)[0]][tmp.get(0)[1]] = false;
					map[tmp.get(0)[0]][tmp.get(0)[1]] = 0;
					tmp.remove(0);			
				}				
			}			
		}
		back(sum, idx+1, coreOn);
		
		return;
	}

	public static boolean able(int r, int c, int dir) {
		int depth = 1;
		int nr = r+(dr[dir]*depth);
		int nc = c+(dc[dir]*depth);
		while (bound(nr,nc)) {
			if(!vst[nr][nc] && map[nr][nc]==0 && (nr==0 || nr==n-1 || nc==0 || nc==n-1)) {
				return true;
			} else if(!vst[nr][nc] && map[nr][nc]==0 ) {
				depth++;
				nr = r+(dr[dir]*depth);
				nc = c+(dc[dir]*depth);
			} else {
				return false; 
			}
		}
		return false;		
	}
	
	public static boolean bound(int r, int c) {
		if(r>=0 && r<n && c>=0 && c<n) return true;
		else return false;		
	}
	
}
