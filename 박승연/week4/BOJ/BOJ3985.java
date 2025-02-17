//BOJ 3985. 롤 케이크(브론즈 1)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3985 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int l = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		int[] cake = new int[l+1]; //0은 안 쓸거임
		int[] r = new int[n+1]; //각 방청객의 케이크 수
		
		
		int[] nums = new int[2];
		int eMax = 0; //기대
		int maxCake = 0;
		int rMax = 0; //실제
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			nums[0] = Integer.parseInt(st.nextToken()); //p~k 조각
			nums[1] = Integer.parseInt(st.nextToken());
			
			if(nums[1]-nums[0]+1>maxCake) {
				eMax = i+1;
				maxCake = nums[1]-nums[0]+1;
			}
						
			for(int j=nums[0]; j<=nums[1]; j++) {
				if(cake[j] == 0) {
					cake[j] = i+1; //케이크에 방청객 번호를 적음
				}
			}			
		}
		
		int max = 0; //케이크 최대 수
		for(int i=1; i<cake.length; i++) {
			if(cake[i] != 0) {
				r[cake[i]]++;
				if(r[cake[i]]>max) {
					rMax = cake[i];
					max = r[cake[i]];
				}
			}			
		}
		
		System.out.printf("%d%n%d", eMax, rMax);		
		
	}
}
