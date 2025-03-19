import java.util.Scanner;
//딱지놀이
public class BOJ14696 {
	public static int star(int[] arr) { //별 개수 
		int s_count =0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==4) {
				s_count++;
			}
		}
		return s_count;
	}
	
	public static int circle(int[] arr) {//동그라미 개수
		int c_count =0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==3) {
				c_count++;
			}
		}
		return c_count;
	}
	
	public static int square(int[] arr) { //사각형개수
		int sq_count =0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==2) {
				sq_count++;
			}
		}
		return sq_count;
	}
	
	public static int triangle(int[] arr) { //삼각형 개수
		int t_count =0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==1) {
				t_count++;
			}
		}
		return t_count;
	}
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int round =sc.nextInt();
		int a =0;
		int b=0;
		for(int i =0; i<round;i++) {
			a=sc.nextInt();
			int[] a_arr =new int[a];
			for(int j=0; j<a; j++) {
				a_arr[j]=sc.nextInt();
			}
			
			b =sc.nextInt();
			int[ ] b_arr =new int[b];
			for(int k=0; k<b;k++) {
				b_arr[k]=sc.nextInt();
			}
			
			if(star(a_arr)>star(b_arr)) {
				System.out.println("A");	
			}else if(star(a_arr)<star(b_arr)){
				System.out.println("B");
			}else if(circle(a_arr)>circle(b_arr)) {
					System.out.println("A");			
			}else if(circle(a_arr)<circle(b_arr)) {
				System.out.println("B");
			}else if(square(a_arr)>square(b_arr)) {
				System.out.println("A");			
			}else if(square(a_arr)<square(b_arr)) {
				System.out.println("B");						
			}else if(triangle(a_arr)>triangle(b_arr)) {
				System.out.println("A");			
			}else if(triangle(a_arr)<triangle(b_arr)) {
				System.out.println("B");						
			}else {
				System.out.println("D");
			}
		}
		sc.close();
}
}
