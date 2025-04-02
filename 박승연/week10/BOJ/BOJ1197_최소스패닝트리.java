
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1197_최소스패닝트리 {
	static class Edge implements Comparable<Edge>{
		int s, e, cost;

		public Edge(int s, int e, int cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
		    if (this.cost < o.cost) return -1;
		    if (this.cost > o.cost) return 1;
		    return 0;
		}	
	}
	
	static int[] p;
	static Edge[] edges;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        edges = new Edge[E];
        
        for(int i=0; i<E; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
        	edges[i] = new Edge(a,b,w);
        }
        
		
		Arrays.sort(edges);
		
		p = new int[V+1];
		for(int i=1; i<=V; i++) {
			p[i] = i;
		}
		
		int ans = 0;
		int pick = 0;
		for(int i=0; i<E; i++) {				
			int px = findSet(edges[i].s);
			int py = findSet(edges[i].e);

			if(px != py) {
				union(px,py);
				pick++;
				ans += edges[i].cost;
			}
			
			if (pick == V) break;
		}
        
        System.out.println(ans);
        
    }
    
	static void union(int x, int y) {
        p[y] = x;
	}

	static int findSet(int x) {
		if(x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
}
