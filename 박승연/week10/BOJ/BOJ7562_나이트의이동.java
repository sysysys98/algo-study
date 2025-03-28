import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7562_나이트의이동 {
	static int n, eR, eC;
    static int[] dr = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dc = {-2, -1, 1, 2, -2, -1, 1, 2}; 
    
    static class Piece{
    	int r, c, v;

		public Piece(int r, int c, int v) {
			this.r = r;
			this.c = c;
			this.v = v;
		}    	
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int tc = Integer.parseInt(br.readLine());
        
        for(int t=0; t<tc; t++) {
        	n = Integer.parseInt(br.readLine());
        	
        	st = new StringTokenizer(br.readLine());
        	int sR = Integer.parseInt(st.nextToken());
        	int sC = Integer.parseInt(st.nextToken());
        	
        	st = new StringTokenizer(br.readLine());
        	eR = Integer.parseInt(st.nextToken());
        	eC = Integer.parseInt(st.nextToken());
        	
        	sb.append(bfs(sR,sC,new boolean[n][n])).append("\n");
        }
        
        System.out.println(sb);
        
    }
    
    static int bfs(int r, int c, boolean[][] vst) { 	
    	Queue<Piece> q = new LinkedList<>();
    	
    	vst[r][c] = true;
    	q.add(new Piece(r,c,0));
    	
    	while(!q.isEmpty()) {
    		Piece p = q.poll();
    		
    		if (p.r == eR && p.c == eC) {
    			return p.v;
    		}
    		
    		for(int d=0; d<8; d++) {
    			int nr = p.r+dr[d];
    			int nc = p.c+dc[d];
    			
    			if(nr>=0 && nc>=0 && nr<n && nc<n && !vst[nr][nc]) {
    				q.add(new Piece(nr,nc,p.v+1));
    				vst[nr][nc] = true;
    			}
    		}
    	}
    	
    	return -1;
    }    
}
