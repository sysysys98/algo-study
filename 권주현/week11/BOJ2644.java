import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2644 {
	//촌수계산
	static int n;
	static int[][] adj;
	static int[] dist;
	static int start;
	static int end;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n =sc.nextInt();
		adj=new int[n+1][n+1];
		dist = new int[n+1];
		
		start =sc.nextInt();
		end =sc.nextInt();
		
		int m = sc.nextInt();
		
		for(int i =0; i<m;i++) {
			int a =sc.nextInt();
			int b =sc.nextInt();
			
			adj[a][b]=adj[b][a]=1;
		}
		bfs(start);
		
		if(dist[end]==0) {
			System.out.println(-1);
		}else {
			System.out.println(dist[end]);
		}
		
	}
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		int d =0;
		dist[start] =d;
		while(!q.isEmpty()) {
			int size =q.size();
			d++;
			for(int j =0; j<size; j++) {
				int curr = q.poll();
				for(int i =1 ;i<n+1;i++) {
					if(adj[curr][i]==1 && dist[i]==0) {
						q.add(i);
						dist[i]=d;
					}
				}
			}
		}
	}

}
