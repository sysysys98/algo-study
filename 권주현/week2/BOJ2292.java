import java.util.Scanner;
//벌집
public class BOJ2292 {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	
	int N = sc.nextInt();
	int center =1;
	int pass =1;
	while(center<N) {  //1_(1),~ 1+6*1_(2),~ 1+6+6*2_(3) ...
		center+=6*pass;
		pass++;
	}
	System.out.println(pass);
	sc.close();
}
}
