import java.util.Scanner;

public class BOJ13300 {
	//방배정
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int N =sc.nextInt();
		int K =sc.nextInt();
		int[] boys =new int[6];
		int[] girls =new int[6];
		for(int i =0; i<N;i++) {
			int a =sc.nextInt();
			int b=sc.nextInt();
			int idx =b-1;
			if(a==1) {
				boys[idx]++;
			}else if(a==0) {
				girls[idx]++;
			}
		}
		//각 배열마다 0번째 인덱스는 1학년, 5번째 인데스는 6학년
		int room_cnt =0;
		for(int i=0;i<6;i++) { //남자애들 방 수
			if(boys[i]!=0) {  //(i+1)학년에 인원이 있다면
				if(boys[i]/K ==0) { //K보다 작다면
					room_cnt++; 
				}else if(boys[i]%K==0) { //K보다 큰데 나누어떨어지면
					room_cnt+=boys[i]/K;
				}else {
					room_cnt+=boys[i]/K+1; //나누어 떨어지지 않으면
				}
			}
		}
		for(int i=0;i<6;i++) { //여자애들 방 수 
			if(girls[i]!=0) {
				if(girls[i]/K ==0) {
					room_cnt++;
				}else if(girls[i]%K==0) {
					room_cnt+=girls[i]/K;
				}else {
					room_cnt+=girls[i]/K+1;
				}
			}
		}
		System.out.println(room_cnt);
		sc.close();
	}
}
