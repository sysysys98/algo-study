import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660_구간합구하기5 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken()); //배열 크기
        int M = Integer.parseInt(st.nextToken()); //구간합을 구해야 하는 횟수
        
        int[][] arr = new int[N + 1][N + 1]; // 인덱스를 1부터 세기 위해 크기 N+1로 설정
        int[][] prefix = new int[N + 1][N + 1]; //즉 0,0은 쓰지 않음
        
        //표 데이터 받기
        for (int i = 1; i <= N; i++) {
        	st = new StringTokenizer(br.readLine()," ");
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        //누적합 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                prefix[i][j] = arr[i][j] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }
        
        //구간합
        for (int k = 0; k < M; k++) {
        	st = new StringTokenizer(br.readLine()," ");
        	//문제상에서는 x가 r, y가 c
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            // 구간 합 계산
            int result = prefix[x2][y2] - prefix[x1 - 1][y2] - prefix[x2][y1 - 1] + prefix[x1 - 1][y1 - 1];
            sb.append(result+"\n");
        }

        System.out.println(sb);
    }
}
