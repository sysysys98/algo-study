import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2252_줄세우기 {	
	static int n, m;
	static List<Integer> adj[];
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        adj = new ArrayList[n+1];
        int[] degree = new int[n+1];
        
        for(int i=0; i<n+1; i++) {
        	adj[i] = new ArrayList<>();
        }
        
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine()," ");
        	int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            adj[s].add(e);
            degree[e]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
		

		for(int i=1; i<n+1; i++) {
			if(degree[i] == 0) q.add(i);
		}

		while(!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr).append(" ");
			
			for(int to : adj[curr]) {
				degree[to]--;
				if (degree[to]==0) q.add(to);		
			}
		}		
		
		System.out.println(sb);	
		
	}
	
}
