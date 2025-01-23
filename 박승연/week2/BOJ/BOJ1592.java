//BOJ 1592. 영식이와 친구들(브론즈 2)
import java.util.*;
import java.io.*;

public class BOJ1592 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());		
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[] cnt = new int[n]; //자리  배열
		//n=9
		//만약 idx가 8+5되어서 13이 되었다면 => 4
		//0 1 2 3 4 5 6 7 8  
		//8 7 6 5 4 3 2 1 0 
		//0 ~ n-1
		//idx가 2-4되어서 -2가 되었다면=>7
		
		//0 1 2 3 4
		//5 4 3 2 1
		
		int ans = 0; //공이 오간 총 횟수
		int idx = 0; //시작하는 사람의 자리
		while(true) {
			cnt[idx]++; //공 받음
			if (cnt[idx] == m) {
				break;
			} else {
				if (cnt[idx]%2 != 0) { //홀수면
					idx += l;
					if (idx > n-1) { //idx가 최대 정원을 넘어가면
						idx = idx - n;
					}
				} else { //짝수면
					idx -= l;
					if (idx<0) { //idx가 음수가 되면
						idx = n+idx; // idx가 음수인 경우이기 때문에 빼면 안 되고 더해야 함
					}
				}
			}
			ans++; //'던진' 수이기 때문에 마지막에 더함
		}		
		System.out.println(ans);		
	}
}
