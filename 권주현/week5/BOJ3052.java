import java.util.Scanner;
//나머지
public class BOJ3052 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array = new int[10];
		for(int i =0; i<array.length;i++) {
			array[i]=sc.nextInt();
		}
		int[] remain =new int[10];
		for(int i=0;i<10;i++) {
			remain[i] = array[i]%42; //나머지 구함
		}
		
		int[] cnt = new int[42]; //42크기 배열 선언
		
		for(int i =0;i<10;i++) {
			cnt[remain[i]]++;	//나머지와 같은 인덱스에 ++
		}
		int count=0;
		for(int i =0; i<42;i++) {
			if(cnt[i]!=0) { //돌면서 0이 아닌 애들만 체크 후 ++
				count++;
			}
		}
		
		System.out.println(count);
		sc.close();	
		
	}

}
