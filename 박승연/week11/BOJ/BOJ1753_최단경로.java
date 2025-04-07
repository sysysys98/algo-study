package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class BOJ1753_최단경로 {
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
	static int v,e;
	static List<Edge>[] adjList; // 인접리스트
	static int[] dist;
	static boolean[] vst;

	public static void main(String[] args) throws Exception, IOException {
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());		
		
		int k = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[v+1];
		vst = new boolean[v+1];
		
		for(int i=0; i<v+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		dist = new int[v+1];
		Arrays.fill(dist, INF);
		
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			adjList[x].add(new Edge(y,z));
		}

		dijkstra(k);
		
		for(int i=1; i<v+1; i++) {
			if(i==k) {
				sb.append(0).append("\n");
			} else if(!vst[i]) {
				sb.append("INF\n");
			} else {
				sb.append(dist[i]).append("\n");
			}
		}
		
		
		System.out.println(sb);
		
	}
	
	private static void dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();		
		
		dist[start] = 0;
		
		pq.add(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			if(vst[curr.to]) continue;
			vst[curr.to]= true;
			
			for(Edge node : adjList[curr.to]) {
				if(!vst[node.to] && dist[node.to] > dist[curr.to]+node.cost) {
					dist[node.to]= dist[curr.to]+node.cost;
					pq.add(new Edge(node.to, dist[node.to]));
				}
			}
		}
		
	}
}
