import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1158_요세푸스문제 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Integer> lst = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			lst.add(i);
		}
		
		int idx = m-1;
		while(lst.size()>1) {
			sb.append(lst.get(idx)).append(", ");
			lst.remove(idx);
			idx += m-1;
			if(idx>=lst.size()) {
				idx %= lst.size();
			}
		}
		sb.append(lst.get(0));
		sb.setLength(sb.length());
		sb.append(">");
		
		System.out.println(sb);
		
	}
}
