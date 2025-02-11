import java.util.Scanner;
//색종이
public class BOJ2563 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int cnt =sc.nextInt();		
		int[][] sum = new int[100][100];
		for(int n=0;n<cnt;n++) {
			int x =sc.nextInt();
			int y =sc.nextInt();
			for(int i =0; i<10;i++) {
				for(int j =0;j<10;j++) {
					sum[x+i][y+j]++; //배열에 1씩 더함
				}
			}
		}
		int area =0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if(sum[i][j]>0) { //0보다 큰 것만 면적으로 계산
					area++;
				}
			}
		}
		System.out.println(area);
	}
}
