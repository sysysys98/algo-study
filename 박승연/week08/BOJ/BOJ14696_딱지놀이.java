import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14696_딱지놀이 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine()); //라운드 수
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			int a = Integer.parseInt(st.nextToken());
			int[] arrA = new int[5]; //4별 3원 2네모 1세모
			for(int j=0; j<a; j++) {
				int input = Integer.parseInt(st.nextToken()); 
				arrA[input]++;
			}
			
			st = new StringTokenizer(br.readLine()," ");
			
			int b = Integer.parseInt(st.nextToken());
			int[] arrB = new int[5];
			for(int j=0; j<b; j++) {
				int input = Integer.parseInt(st.nextToken()); 
				arrB[input]++;
			}
			
			boolean flag = false;
			for(int j=4; j>0; j--) {
				if(arrA[j] != arrB[j]) {
					sb.append(arrA[j]>arrB[j] ? "A" : "B").append("\n");
					flag = true; //무승부가 아니고 승자가 가려짐
					break;
				}			
			}
			
			if(!flag) {
				sb.append("D\n"); //무승부
			}			
			
		}
		
		System.out.println(sb);
	}
		
}
