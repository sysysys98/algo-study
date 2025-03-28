import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17413_단어뒤집기2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		String input = br.readLine();
		char[] arr = input.toCharArray();
		
		StringBuilder tmp = new StringBuilder();
		boolean flag = false; //괄호 안인지 여부
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == '<') {	
				if(tmp.length()>0) {
					sb.append(tmp.reverse());
					tmp.setLength(0);//tmp 비움
				}
				sb.append(arr[i]);
				flag=true;
			} else if(arr[i] == '>') {
				sb.append(tmp).append(arr[i]);
				tmp.setLength(0);//tmp 비움
				flag=false;
			} else {
				if(!flag && arr[i] == ' ') { //괄호 안이 아니고 공백이면
					sb.append(tmp.reverse()).append(" "); //뒤집어서 넣고
					tmp.setLength(0);//tmp 비움
				} else {
					tmp.append(arr[i]);
				}
			}			
		}
		
		if(tmp.length()>0) {
			sb.append(tmp.reverse());
		}
		
		System.out.println(sb);
		
	}
}
