import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13300_방배정 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[2][7]; //성별, 학년
		int room = 0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int s = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[s][y]++;
			if(arr[s][y]==1) {
				room++;
			}
			if(arr[s][y]==k+1) {
				room++;
				arr[s][y] = 1;
			}
		}
		
		System.out.println(room);
		
	}
}
