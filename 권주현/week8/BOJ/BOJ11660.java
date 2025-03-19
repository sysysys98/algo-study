import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660 {
	//구간 합 구하기 5
	
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int N = Integer.parseInt(st.nextToken());
	int M =Integer.parseInt(st.nextToken());
	int[][] board = new int[N][N];
	int[][] cum = new int[N][N];
	
	int sum =0;
	for(int i=0; i<N;i++) {
		st = new StringTokenizer(br.readLine()); 
		for(int j =0; j<N;j++) {
			board[i][j]=Integer.parseInt(st.nextToken());
			sum+=board[i][j];
			cum[i][j] =sum;
		}
	}
	
	for(int cnt=1;cnt<=M;cnt++) {
		st = new StringTokenizer(br.readLine());
		int start_x = Integer.parseInt(st.nextToken())-1;
		int start_y = Integer.parseInt(st.nextToken())-1;
		int end_x = Integer.parseInt(st.nextToken())-1;
		int end_y = Integer.parseInt(st.nextToken())-1;
		int total_sum =0;
		for(int x =start_x;x<=end_x;x++) {
			if(start_y==end_y) total_sum +=board[x][start_y];
			else {
				total_sum +=cum[x][end_y]-cum[x][start_y]+board[x][start_y];
			}
		}
		
		System.out.println(total_sum);
	}
	
}
}
