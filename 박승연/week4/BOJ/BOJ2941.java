//BOJ 2941. 크로아티아 알파벳(실버 5)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ2941 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		String[] apb = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		String input = br.readLine();
		List<Character> arr = new ArrayList<>();
		int idx=0;
		while(idx<input.length()) {
			arr.add(input.charAt(idx++));
		}
		String tmp = "";
		
		int cnt = 0;
		while (arr.size()>1) { //최소 두 개는 있어야 비교 가능함
			tmp = arr.get(0)+""+arr.get(1); //두글자를 붙여보고
			if(arr.size()>2 && tmp.equals("dz") && arr.get(2)=='=') { //dz=인 경우
				cnt++; 
				arr.remove(0);
				arr.remove(0);
				arr.remove(0);
				continue;
			}
			boolean flag = false;
			for(int j=0; j<apb.length; j++) {
				if(tmp.equals(apb[j])) { //그게 변경 알파벳 리스트에 있는 것과 같으면
					cnt++; 
					arr.remove(0);
					arr.remove(0); //수를 세고 목록에서 지운다.
					flag = true;
					break;
				}
			}
			//만약에 같은 게 없었으면
			if(!flag) {
				cnt++;
				arr.remove(0); //1개짜리 알파벳임
			}			
		}
		if (arr.size()==1) {
			cnt++;
		}
		System.out.println(cnt);
	}

}
