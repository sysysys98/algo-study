package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4485_녹색옷입은애가젤다지 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0,0,1,-1};
	static class Edge implements Comparable<Edge> {
		int r, c, cost;

		public Edge(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static int n;
	static List<Edge>[][] adjList; // 인접리스트
	static int[][] dist;

	public static void main(String[] args) throws Exception, IOException {
		StringBuilder sb = new StringBuilder();
		int tc = 1;
		while(true) {
			n = Integer.parseInt(br.readLine());
			
			if (n==0) break;
			else {
				input(n);
				sb.append("Problem ").append(tc).append(": ").append(dist[n-1][n-1]).append("\n");
			}
			tc++;
		}
		
		System.out.println(sb);
	}
	
	private static void input(int n) throws IOException {
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		adjList = new ArrayList[n][n];
		
		for (int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				adjList[i][j] = new ArrayList<>();
			}
		}
		
		dist = new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(dist[i], INF);
		}
		
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				for(int d=0; d<4; d++) {
					int nr = i+dr[d];
					int nc = j+dc[d];
					
					if(nr>=0 && nc>=0 && nr<n && nc<n) {
						adjList[i][j].add(new Edge(nr,nc,map[nr][nc]));
					}
				}
			}
		}
		
		dijkstra(0,0);
		
	}

	private static void dijkstra(int sr, int sc) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[][] visited = new boolean[n][n];

		dist[sr][sc] = map[sc][sc]; 

		pq.add(new Edge(sr,sc,map[sr][sc]));

		while (!pq.isEmpty()) {
			Edge curr = pq.poll();

			if (visited[curr.r][curr.c])
				continue; // 이미 방문한 곳은 비용을 알고 있으므로 pass
			visited[curr.r][curr.c] = true; // 선택

			for (Edge node : adjList[curr.r][curr.c]) {
				if (!visited[node.r][node.c] && dist[node.r][node.c]  > dist[curr.r][curr.c]  + node.cost) {
					dist[node.r][node.c] = dist[curr.r][curr.c]  + node.cost;
					pq.add(new Edge(node.r, node.c, dist[node.r][node.c] ));
				}
			}
		}

	}
}
