//BOJ 2477. 참외밭(실버 2)
import java.io.*;
import java.util.*;

public class BOJ2477 {
	
	static int[] dir = new int[5]; // 1동 2서 3남 4북
	
	public static int over(int number) {
//		System.out.println(number+"가 들어옴");
		if (number > 5) {
			number -= 6;
		} else if (number < 0) {
			number = 6+number;
		}	
//		System.out.println(number+"가 나감");
		return number;
		
	}
	
	static class Line{
		int len;
		int d;
		
		Line(int len, int d) {
			this.len = len;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Line[] lines = new Line[6]; 

		int d = 0; //방향
		int len = 0; //길이
		int long1 = 0;
		int long2 = 0;

		
		int k = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine()," ");
			d = Integer.parseInt(st.nextToken());
			len = Integer.parseInt(st.nextToken());
			
			dir[d]++;
			lines[i] = new Line(len, d);
		}
		
		for(int i=1; i<5; i++) {
			if (dir[i] == 1) {
				if (long1 == 0) {
					long1 = i;
				} else {
					long2 = i;
				}
			}
		}		
		
		int ans = 0;
		int idx1 = 0;
		int idx2 = 0;
		for (int i=0; i<6; i++) {
			if (lines[i].d == long1 || lines[i].d == long2) {
				if (idx1 == 0) {
					idx1 = i;
//					System.out.println(i+"는 긴 모서리");
				} else {
					idx2 = i;
//					System.out.println(i+"는 긴 모서리");
				}
				
				if (ans == 0) {
					ans += lines[i].len;
					
				} else {
					ans *= lines[i].len;
				}
			}
		}
		
		int empty;
		if(idx1==0&&idx2==5 || idx1==5&&idx2==0) {
			empty = lines[3].len * lines[2].len;
			ans -= empty;
			System.out.println(ans*k);		
			return;
		}
		//위는 만약 긴 모서리 두 개의 idx가 0, 5일 경우
		//아래 식으로 빼야 할 도형의 모서리를 구하면 반대로 넘어가서(교차되어서)
		//정상적으로 답이 구해지지 않을 경우의 예외처리
		
		if(idx1>idx2) {
			idx1 +=2;
			idx2 -=2;
		} else {
			idx1 -=2;
			idx2 +=2;
		}
		
		idx1 = over(idx1);
		idx2 = over(idx2);
		
		empty = lines[idx1].len * lines[idx2].len;
		
		ans -= empty;
		//dir 배열에서 값이 1인 방향을 찾는다 = 온전한 모서리 2개
		//for문으로 line 배열을 순회하면서
		//	//1. d가 온전한 모서리인 경우
			//	그 모서리의 idx를 저장해놓는다
			// => ans이 0이면 그 값을 더하고 아니면 그 값을 곱함
		//온전한 모서리의 idx에 +- 2씩을 해서 뺄 사각형 길이를 구한다
		//뺀다	
		
		System.out.println(ans*k);			
	}
}