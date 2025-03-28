//BOJ 2292. 벌집(브론즈 2)
//import java.util.*;
import java.io.*;

public class BOJ2292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		int n = Integer.parseInt(br.readLine());	
		
		int cnt = 1; //1개로 시작
		int num = 1; //6의 몇배수를 더할건지
		int start = 1;
		
		if (n==1) {
			System.out.println(1);
			return;
		}
		
		while(true) {
			start += num*6;
			if (n <= start) {
				System.out.println(cnt+num);
				return;
			} else {
				num++;
			}		
		}			
	}
}

//1: 1
//2: 2~7(6개)
//3: 8~19(12개)
//4: 20~37(18개)
//5: 38~61(24개)

