//BOJ 1260. DFS와 BFS(실버 2)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class BOJ1260 {
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> grp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		grp = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			grp.add(new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			grp.get(a).add(b);
			grp.get(b).add(a);
		}
		
		for(int i=0; i<grp.size(); i++) {
			grp.get(i).sort(Integer::compareTo);
		}
		
		visited = new boolean[n+1];
		dfs(v);
		System.out.println();
		visited = new boolean[n+1];
		bfs(v);
		
	}
	
	static void dfs(int v) {
		visited[v] = true;
		System.out.print(v+" ");
		
		ArrayList<Integer> arr = grp.get(v);
		for(int i: arr) {
			if(!visited[i]) {
				dfs(i);
			}
		}
	}
	
	static void bfs(int v) {
		LinkedList<Integer> q = new LinkedList<>(); 
		q.addLast(v);
		visited[v] = true;
		while(!q.isEmpty()) {
			int tmp = q.removeFirst();
			System.out.print(tmp+" ");
			for(int i: grp.get(tmp)) {
				if(!visited[i]) {
					q.addLast(i);
					visited[i] = true;
				}
			}
		}		
		
	}
}
