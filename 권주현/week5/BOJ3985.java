import java.util.Scanner;
//롤케이크
public class BOJ3985 {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	int L =sc.nextInt();
	int p = sc.nextInt();
	int[][] arr= new int[p][2];  //행마다 2열(시작, 끝)
	int[] cnt =new int[p];
	
	for(int i =0; i<p;i++) {
		for(int j =0;j<2; j++) {
			arr[i][j] =sc.nextInt();
		}		
		cnt[i] =arr[i][1]-arr[i][0]+1; //나누기전에 입력만으로 가질 수 있는 케이크계산
	} 
	
	int max =0;
	int max_idx =-1;
	for(int i =0; i<p;i++) { //가장 많은 조각을 받을 것으로 기대하고 있던 방청객의 번호
		if(max<cnt[i]) {
			max=cnt[i];
			max_idx= i;
		}
	}
	System.out.println(max_idx+1);//0번째부터 사람이므로 1+
	
	int[] cake = new int[L];
	for(int i =0; i<p; i++) {
		int start = arr[i][0]-1;  //인덱스 주의(배열은 0부터)
		int end =arr[i][1]-1;
		for(int j =start; j<=end; j++) {
			if(cake[j]==0)cake[j] = i+1;//+1은 케이크배열 요소를 사람번호로 할려고
		}
		
	}
	int[] real =new int[p+1];//사람번호를 인덱스로 사용할 수 있게 p+1
	for(int i=0;i<L;i++) {  //인덱스 사람번호에 값을 1씩++
		if(cake[i]>0)
		real[cake[i]]++;
	}
	int real_max=0;
	int real_max_idx=-1;
	for(int i =0; i<p+1;i++) {  //실제 최대로 받은 사람 번호 출력
		if(real_max<real[i]) {
			real_max=real[i];
			real_max_idx= i;
		}
	}
	System.out.println(real_max_idx);
}
}
