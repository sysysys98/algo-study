import java.util.Scanner;
//크로아티아 알파벳
public class BOJ2941 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	String str = sc.nextLine();
	int l =str.length();
	
	int cnt =0;
	for(int i =0; i<l;i++) {
		if(str.charAt(i)=='c') {
			if(i<l-1) {
				if(str.charAt(i+1)=='=') {
					i++;	
				}else if(str.charAt(i+1)=='-') {
					i++;				
				}
			}
		}else if(str.charAt(i)=='d') {
			if(i<l-1) {
			if(str.charAt(i+1)=='-') {
				i++;
			}else if(str.charAt(i+1)=='z') {
				if(i<l-2) {
					if(str.charAt(i+2)=='=') {
						i+=2;
					}
				}
			}	
			}
		}else if(str.charAt(i)=='l') {
			if(i<l-1) {
			if(str.charAt(i+1)=='j') {
				i++;
			}		
			}
		}else if(str.charAt(i)=='n') {
			if(i<l-1) {
			if(str.charAt(i+1)=='j') {
				i++;
			}
			}
		}else if(str.charAt(i)=='s') {
			if(i<l-1) {
			if(str.charAt(i+1)=='=') {
				i++;
			}
			}
		}else if(str.charAt(i)=='z') {
			if(i<l-1) {
			if(str.charAt(i+1)=='=') {
				i++;
			}
		}
	}
				cnt++;
	}
	
	System.out.println(cnt);
	
}
}
