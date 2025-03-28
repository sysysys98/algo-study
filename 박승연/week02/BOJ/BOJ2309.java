//BOJ 2309. 일곱 난쟁이(브론즈 1)
import java.io.*;
import java.util.*;

public class BOJ2309 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		List<Integer> h = new ArrayList<>();
		int sum = 0;
		
		int insert = 0;
		for(int i=0; i<9; i++) {
			insert = Integer.parseInt(br.readLine());
			h.add(insert);	
			sum += insert;
		}
		
		int tmp = sum-100; //총합이 100보다 얼마나 큰지
		int del1 = 0; //지울 값1
		int del2 = 0; //지울 값2
			
		for (int i=0; i<9; i++) {
			for (int j=i+1; j<9; j++) {
				if (tmp == h.get(i) + h.get(j)) { //두 수의 합이 초과값과 같으면
					del1 = h.get(i); //지울 값에 추가한다
					del2 = h.get(j);
				}
			}
		}
		
		Collections.sort(h); //배열을 오름차순으로 정렬
		
		for (int i=0; i<9; i++) {
			if (h.get(i)!=del1 && h.get(i)!=del2) { //지울 값만 제외하고 출력값에 넣는다
				sb.append(h.get(i)).append("\n");
			}
		}
			
		System.out.println(sb);			
	}
}