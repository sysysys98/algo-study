import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj5014 {
//스타트링크
	
	static int F;
	static int S;
	static int G;
	static int U;
	static int D;
	static int[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F=sc.nextInt();
		S=sc.nextInt();
		G=sc.nextInt();
		U=sc.nextInt();
		D=sc.nextInt();
		visited = new int[F+1];
		if(S==G){
			System.out.println(0);		
		}else {
			bfs(S);
			if(visited[G]==0) {
				System.out.println("use the stairs");
			}else {		
				System.out.println(visited[G]);
			}
		}		
		
	}
	private static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		int cnt =0;
		visited[node]=cnt;
		while(!q.isEmpty()) {
			int size =q.size();
			cnt++;
			for(int i=0;i<size;i++ ) {
				int curr =q.poll();
				if(curr==G) return;
				if(curr-D>=1 &&visited[curr-D]==0) {
					q.add(curr-D);
					visited[curr-D]=cnt;
				}
				if(curr+U<=F &&visited[curr+U]==0) {
					q.add(curr+U);
					visited[curr+U]=cnt;
				}
			}
		}
		
	}
}
