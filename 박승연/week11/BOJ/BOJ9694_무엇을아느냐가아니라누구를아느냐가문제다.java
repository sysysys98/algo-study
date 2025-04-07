package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ9694_무엇을아느냐가아니라누구를아느냐가문제다 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static class Edge implements Comparable<Edge> {
		int to, cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int n,m;
	static List<Edge>[] adjList; // 인접리스트
	static int[] dist, prev;
	static List<Integer> ans;

	public static void main(String[] args) throws Exception, IOException {
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=tc; t++) {
			st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			adjList = new ArrayList[m];
			
			for(int i=0; i<m; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			dist = new int[m];
			prev = new int[m];
			Arrays.fill(dist, INF);
			Arrays.fill(prev, -1);
			
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				
				adjList[x].add(new Edge(y,z));
				adjList[y].add(new Edge(x,z));
			}
			
			ans = new ArrayList<>();
			sb.append("Case #").append(t).append(": ");
			
			if(!dijkstra(0)) {
				sb.append(-1).append("\n");
			} else {
				path(m-1);
				for(int num : ans) {
					sb.append(num).append(" ");
				}
				sb.append("\n");
			}		
			
		}
		
		System.out.println(sb);
		
	}
	
	private static boolean dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] vst = new boolean[m];
		
		dist[start] = 0;
		
		pq.add(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			if(vst[curr.to]) continue;
			vst[curr.to]= true;
			
			for(Edge node : adjList[curr.to]) {
				if(!vst[node.to] && dist[node.to] > dist[curr.to]+node.cost) {
					dist[node.to]= dist[curr.to]+node.cost;
					prev[node.to] = curr.to;
					pq.add(new Edge(node.to, dist[node.to]));
				}
			}
		}
		
		if(!vst[m-1]) {
			return false;
		} else {
			return true;
		}
		
	}
	
	private static void path(int end) {
		if(end==-1) return;
		path(prev[end]);
		ans.add(end);
	}
}
