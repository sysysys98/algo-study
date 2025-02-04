import java.util.Scanner;
//참외밭
//큰직사각형에서 작은 직사각형빼기
public class BOJ2477 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K =sc.nextInt();
		int[] direction =new int[6];//방향 저장
		int[] len =new int[6];//길이 저장
		
		for(int i=0;i<6;i++) {
			direction[i]=sc.nextInt();
			len[i]=sc.nextInt();
		}
		int max_w =0;
		int max_w_idx=0;
		int max_h=0;
		int max_h_idx =0;
		
		for(int i =0;i<6;i++) {
			if(direction[i]==1 || direction[i]==2) {
				if(len[i]>max_w) {
					max_w=len[i];  //큰직사각형 가로
					max_w_idx=i;  //그때 인덱스 저장
				}
			}
			if(direction[i]==3 || direction[i]==4) {
				if(len[i]>max_h) {
					max_h=len[i]; //큰직사각형 세로
					max_h_idx=i; //그때 인덱스 저장
				}
			}
		}
		int min_w_idx =max_h_idx+3;  //작은직사각형가로 인덱스
		int min_h_idx=max_w_idx+3;  //작은 직사각형 세로 인덱스
		if(min_w_idx>=direction.length) { //인덱스 벗어난경우 인덱스 범위안으로 조정
			min_w_idx-=direction.length;
		}
		int min_w = len[min_w_idx]; //작은 직사각형 가로
		if(min_h_idx>=direction.length) {//인덱스 벗어난경우 인덱스 범위안으로 조정
			min_h_idx-=direction.length; 
		}
		int min_h=len[min_h_idx];//작은 직사각형 세로
	
		System.out.println(K*(max_w*max_h-min_w*min_h)); //1m^2당 참외개수*(큰직사각형넓이-작은직사각형넓이)
		sc.close();
	}

}
