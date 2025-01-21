import java.util.Scanner;

//1 -> 직사각형 수:1 약수:1
//2 -> 직사각형 수:1 약수:1,2
//3 -> 직사각형 수:1 약수:1,3
//4 -> 직사각형 수:2 약수:1,2,4
//5 -> 직사각형 수:1 약수:1,5
//6 -> 직사각형 수:2 약수:1,2,3,6
//7 -> 직사각형 수:1 약수:1,7
//8 -> 직사각형 수:2 약수:1,2,4,8
//9 -> 직사각형 수:2 약수:1,3,9
//10 -> 직사각형 수:2 약수:1,2,5,10
//11 -> 직사각형 수:1 약수:1,11
//12 -> 직사각형 수:3 약수:1,2,3,4,6,12


//약수가 1개일 경우 직사각형 수:1
//약수가 2개일 경우 직사각형 수:1       약수의 개수가 짝수인 경우: 직사각형 수: 약수/2
//약수가 3개일 경우 직사각형 수:2		약수의 개수가 홀수인 경우: 직사각형 수: 약수/2+1
//약수가 4개일 경우 직사각형 수:2



public class Square {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int sum =0; 
		for(int i =1;i<=count; i++) {
			int measure =0;
			for(int j =1;j<=i;j++) {
				if(i%j==0) measure++; 
			}
				if(measure%2==0) {
					sum +=measure/2;
				}else {
					sum +=measure/2+1;
				}
		
		}
		System.out.println(sum);
		sc.close();
	}

}
