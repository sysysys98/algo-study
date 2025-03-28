import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10158_개미 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());

		int tmp_p = (t+p)%(w*2);
		int tmp_q = (t+q)%(h*2);
		
		if(tmp_p > w) {
			tmp_p = w - (tmp_p-w);
		}
		
		if(tmp_q > h) {
			tmp_q = h - (tmp_q-h);
		}
		

		System.out.println(tmp_p+" "+tmp_q);
		
	}
}