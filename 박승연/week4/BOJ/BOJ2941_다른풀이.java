import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2941_다른풀이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		int cnt = 0;
		
		for (int i=0; i<sb.length()-2;i++){
			if (sb.substring(i,i+3).equals("dz=")){
				cnt++;	
				sb.replace(i,i+3," ");
				i--;			
			}
		}
		for (int i=0; i<sb.length()-1;i++){
			if (compareAbc(sb.substring(i,i+2))==1){
				cnt++;	
				sb.replace(i,i+2," ");
				i--;			
			} 
		} 
		for (int i=0; i<sb.length();i++){
			if (!sb.substring(i,i+1).equals(" ")){
				cnt++;	
				sb.delete(i,i+1);
				i--;			
				}
			}
		System.out.println(cnt);
	
}


	
	public static int compareAbc(String a) {
		String[] all = {"c=", "c-", "d-", "lj", "nj", "s=", "z="};
		for (int i=0; i<7; i++){
			if (a.equals(all[i])){ 
				return 1;
				}
			}
			
		return 0;
		
	}	

}
