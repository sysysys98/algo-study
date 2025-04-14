import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1697 {
	//숨바꼭질
	static int N;
	static int K;
	static int[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N =sc.nextInt();
		K =sc.nextInt();
		visited= new int[1000001];
		
		
		bfs(N);
		
		System.out.println(visited[K]);
	}
	private static void bfs(int node) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		int dist =0;
		visited[node]=dist;
		while(!q.isEmpty()) {
			int size =q.size();
			dist++;
			for(int i=0;i<size;i++) {
				int x =q.poll();
				if(x==K) return;
				if(x-1>=0 && visited[x-1]==0) {
					q.add(x-1);
					visited[x-1]=dist;
				}
				if(x+1<=100000 && visited[x+1]==0) {
					q.add(x+1);
					visited[x+1]=dist;
				}
				if(x*2<=100000 && visited[x*2]==0) {
					q.add(x*2);
					visited[x*2]=dist;
				}
			}
			
			
			
		}
		
		
	}
}
