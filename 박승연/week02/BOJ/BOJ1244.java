//BOJ 1244. 스위치 켜고 끄기(실버 4)
import java.util.*;
import java.io.*;

public class BOJ1244 {
	public static int n = 0;
	public static int[] swt; //스위치 상태 바꾸기 편하게 static으로 만듦
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		swt = new int[n]; //스위치 배열 생성
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i=0; i<n; i++) {
			swt[i] = Integer.parseInt(st.nextToken());
		} //현재 상태 입력
		
		int student = Integer.parseInt(br.readLine()); //학생 수
		
				
		for (int i=0; i<student; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int isBoy = Integer.parseInt(st.nextToken()); //1=남 2=여
			int number = Integer.parseInt(st.nextToken()); //받은 수
			
			if (isBoy == 1) {
				boy(number);				
			} else {
				girl(number);
			}
		}
		
		for (int i=0; i<n; i++) {
			if (i>0 && i%20==0) { //스위치 20개마다 줄바꿈 추가
				sb.append("\n");
			}
			sb.append(swt[i]).append(" ");
			
		}
		System.out.println(sb);		
	}
	
	//스위치를 반대로 끄거나 켜는 함수
	public static void onOff(int t) { //target
		if (swt[t] == 1) {
			swt[t] = 0;
		} else {
			swt[t] = 1;
		}
	}
	
	//남학생의 경우
	public static void boy(int number) {
		int target = number-1;
		while (target<swt.length) {			
			onOff(target);
			target += number;
		}		
	}
	
	//여학생의 경우
	public static void girl(int number) {
		onOff(number-1);
		
		int l = number-2; //left
		int r = number; //right		
		
		while(l>=0 && r<n) {
			if (swt[l] == swt[r]) {
				onOff(l);
				onOff(r);
				l--;
				r++;
			} else {
				break;
			}
		}		
	}
}
