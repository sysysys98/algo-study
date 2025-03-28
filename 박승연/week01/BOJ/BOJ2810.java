//BOJ2810. 컵홀더(브론즈1)
//import java.util.*;
import java.io.*;

public class BOJ2810 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	//1. n 받기
    	//2. int cnt = 1; (맨왼쪽은 무조건 컵이 있으니 1로 시작)
    	//3. char 배열로 input을 받아서 for문으로 순회 시작
    		//S는 양옆에 컵홀더 있음
    		//나머지(L)인 경우 한쪽만 사용 가능하므로 cnt++
    		//나머지 한쪽은 사용 불가하므로 i++해서 pass
    	//4. 답 출력
    		// cnt가 n보다 크면 안 되므로(최대 사람 수를 구해야 하기 때문에)
    		// 대소 비교 후 n이 작으면 n을 출력

    	
    	// 3
    	// *S*S*S*
    	
    	// 4
    	// *LL*S*S
    	
    	// 2
    	// *LL*
    	
    	// 3
    	// *LL*S*
    	
    	// 4
    	// *LL*LL*
    	
    	// 6
    	// *S*LL*LL*S*
    	
    	// 4
    	// LLSS
    	// 처음 3 나온 반례 (정답: 4)
    	
	    int n = Integer.parseInt(br.readLine());
	    
	    int cnt = 1;
	    
	    char[] arr = br.readLine().toCharArray();
	    
	    for (int i=0; i<arr.length; i++) {
	    	if (arr[i] == 'S') {
	    		cnt++;	    		
	    	} else {
	    		cnt++;
	    		i++;
	    	}	    		  	
	    }
	    
	    if (cnt > n) {
	    	System.out.println(n);
	    } else {
	    	System.out.println(cnt);
	    }
//	    System.out.println(Math.min(cnt,n));
    }
}
