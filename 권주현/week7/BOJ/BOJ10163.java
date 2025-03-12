import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//색종이
public class BOJ10163 {
public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	int N =Integer.parseInt(st.nextToken());
	
	int[][] arr = new int[1001][1001];
	int[][] start= new int[N][2];// 위치 index 저장 배열
	int[][] wh= new int[N][2];// 너비 높이 저장배열
	for(int t=0; t<N;t++) {
	st = new StringTokenizer(br.readLine());
	int r = Integer.parseInt(st.nextToken());
	int c = Integer.parseInt(st.nextToken());
	start[t][0]=r;
	start[t][1]=c;
	int w = Integer.parseInt(st.nextToken());
	int h = Integer.parseInt(st.nextToken());
	wh[t][0]=w;
	wh[t][1]=h;
	for(int i = r;i<r+w;i++) {
		for(int j =c;j<c+h;j++) {
			arr[i][j]=t+1; //색종이는 1번부터 이므로 + 덮어쓰기 방식
		}
	}
	}
	for(int t=0; t<N;t++) { 
		int cnt =0;
		for(int i=start[t][0]; i<start[t][0]+wh[t][0];i++) { //전체 탐색 x, 처음 색칠한 범위만 탐색
			for(int j =start[t][1];j<start[t][1]+wh[t][1];j++) {
				if(arr[i][j]==t+1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
}
