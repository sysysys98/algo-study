import java.util.Scanner;
//색종이-2
public class BOJ2567 {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int cnt =sc.nextInt();		
	int[][] sum = new int[101][101]; //이거 때문에 런타임에러남 둘레여서 1씩 늘려줘야되요
	for(int n=0;n<cnt;n++) {
		int x =sc.nextInt();
		int y =sc.nextInt();
		for(int i =0; i<10;i++) {
			for(int j =0;j<10;j++) {
				sum[x+i][y+j]++; //배열에 1씩 더함
			}
		}
	}
	int round =0;
	for(int i=1;i<101;i++) {
		for(int j=1;j<101;j++) {
			if(sum[i][j]>0) {   //색종이로 덮일때
				if(sum[i-1][j]==0) { //아래가 둘레일때
					round++;
				}
				if(sum[i+1][j]==0) { //위가 둘레일때
					round++;
				}
				if(sum[i][j-1]==0) { //왼쪽이 둘레일때
					round++;
				}
				if(sum[i][j+1]==0){ //오른쪽이 둘레일때
					round++;
				}
			}
		}
	}
	System.out.println(round);
}
}
