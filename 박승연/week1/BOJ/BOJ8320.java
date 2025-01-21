//8320. 직사각형을 만드는 방법(브론즈2)
import java.util.*;
import java.io.*;

public class BOJ8320 {
    public static void main(String[] args) throws IOException {
    	StringBuilder sb = new StringBuilder();
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	//1. n 받기
    	//2. int ans = n 선언 (한 줄로 늘어놓았을 때 만들어지는 경우의 수)
    	//3. for 문으로 나머지 경우 더하기
    	// 만약에 input이 12라면
    	//	 1	2	3	4	5	6	7	8	9 ... 12
    	// 1 o	o	o	o	o	o	o	o	o	  o <- n가지 경우(이미 더함)
    	// 2 x  o	o	o	o	o					<-2줄짜리 도형을 만드는 경우
    	// 3 x	x	o	o							<-3줄짜리 도형을 만드는 경우
    	// 4 x	x	x	x
    	// 5
    	// 6
    	// 7
    	//x는 이미 더한 경우이기 때문에 세지 않음
    	    	
    	
	    int n = Integer.parseInt(br.readLine());
	    
	    if (n<4) {
	    	System.out.println(n);
	    	return;
	    }
	    int ans = n;
	    int limit = (int) Math.sqrt(n); //제곱근(소수점 버림)을 구함
	    for (int i=2; i<=limit; i++) {
	    	for (int j=i; j<n; j++) {
	    		if (i*j>n) break;
	    		ans++;
	    	}	    	
	    }
	    System.out.println(ans);
    }
}
