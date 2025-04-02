package 백준;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2606 {
	//바이러스
	static int V;
	static int[][] adj;
	static boolean[] visited;
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V =sc.nextInt();
		int E =sc.nextInt();
		
		adj = new int[V+1][V+1];
		visited= new boolean[V+1];
		cnt =0;
		for(int i =0; i<E; i++) {
			int a =sc.nextInt();
			int b =sc.nextInt();
			
			adj[a][b] =adj[b][a]=1;
		}
		
		//dfs(1);
		bfs(1);
		
		System.out.println(cnt);
		
	}

	static void bfs(int i) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		visited[i]=true;
		while(!q.isEmpty()) {
			int node =q.poll();
			for(int j =1;j<V+1;j++) {
				if(adj[node][j]==1 && !visited[j]) {
					visited[j]=true;
					cnt++;
					q.add(j);
				}
			}
		}
		
	}

	static void dfs(int start) {
		visited[start] =true;
		
		for(int i =1; i<V+1; i++) {
			if(adj[start][i]==1 && !visited[i]) {
				visited[i]=true;
				cnt++;
				dfs(i);
			}
		}
		
	}
	
	
}
