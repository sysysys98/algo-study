//8958. OX퀴즈(브론즈2)
import java.util.*;
import java.io.*;

public class BOJ8958 {
    public static void main(String[] args) throws IOException {
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	//1. t 받기
    	//2. for문 t번 받기
    	//3. while(true)
    		// 1) int score, int cnt = 0 선언
    		// 2) O일 때까지는 cnt++, score += cnt
    		// 3) X일 때 cnt = 0 만들고 pass
    		// 4) 줄바꿈시 score 출력 후 break
    
//	    Scanner sc = new Scanner(System.in);
	    
	    int t = Integer.parseInt(br.readLine());
//	    System.out.println(t);
	    for (int i=0; i<t; i++) {
	    	int score = 0;
	    	int cnt = 0;
	    	
	    	char[] input = br.readLine().toCharArray();
//	    	System.out.println(input[1]);
	    	for (int j=0; j<input.length; j++) {
	    		if (input[j] == 'O') {
	    			cnt++;
	    			score += cnt;
	    		} else {
	    			cnt = 0;
	    		}    		
	    	}
	    	sb.append(score).append("\n");
	    }
	    System.out.println(sb);
    }
}