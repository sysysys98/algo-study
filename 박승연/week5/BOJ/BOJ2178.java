import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {

	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int m,n;
	static Queue<Node> q = new LinkedList<>();
	static int[][] map;
	
	static class Node {
		int r;
		int c;
		int value;
		public Node(int r, int c, int value) {
			this.r = r; //y축(n)
			this.c = c; //x축(m)
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken()); //행 r
		m = Integer.parseInt(st.nextToken()); //열 c
		//최소 칸수
		map = new int[n+1][m+1];
		
		for(int i=0; i<n; i++){
			char[] input = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				map[i+1][j+1] = input[j]-'0';				
			}
		}		
		
		//아래는 디버깅용
//		for(int i=0; i<n+1; i++) {
//			for(int j=0; j<m+1; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		System.out.println(BFS(1,1,new boolean[n+1][m+1]));
		
	}
	
	static int BFS(int y, int x, boolean[][] visited) {
		visited[y][x] = true; //방문처리
		q.add(new Node(y,x, map[y][x])); //시작점을 q에 넣음
		
		while(!q.isEmpty()) { //q에 남은 게 있으면
			Node now = q.poll(); // 하나를 빼내고

//			System.out.println("value: "+now.value+" y: "+now.r+" x: "+now.c);
			if(now.c==m && now.r==n) { //그 빼낸 노드가 도착지점이면 누적된 value return
				return now.value;
			}
			for(int d=0; d<4; d++) { //아니면 주변 칸으로 이동
				int ny = now.r+dy[d];
				int nx = now.c+dx[d];				
				
				if( nx < m+1 && nx >= 0 && ny < n+1 && ny >=0 && !visited[ny][nx] && map[ny][nx] != 0) {
					visited[ny][nx] = true;
					q.add(new Node(ny,nx, now.value+map[ny][nx])); //인접칸으로 계속 이동하며 값을 누적
					
				}				
			}			
		}				
		return -1; //정상적으로 탐색이 됐다면 아예 이 구간은 실행되지 않음(위에서 return됨)		
	}
}
