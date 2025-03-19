import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1158 {
	
	//요세푸스 문제
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int N = sc.nextInt();
	int K = sc.nextInt();
	
	
	boolean[] arr = new boolean[N];
	
	Queue<Integer> queue = new LinkedList<>();
	
	int cnt=0;// 요소 개수
	int idx=0;// 배열 인덱스
	while(cnt <N) { //요소가 다 나오면 WHILE문 끝
		int pass =0;// 몇번째 건너뛰었는지
		while(pass<K) {// K번째로 건너뛰면 WHILE문끝
			if(arr[idx%N]==false) { //뺀 것이 아니라면
				pass++;	//건너뛴거라고 생각
			}
			idx++;// 다음 인덱스로
		}
		arr[(idx-1)%N]=true;// 그 요소를 뺐다고 표현
		queue.offer((idx-1)%N+1); //뺸 것을 큐에 넣는다
		cnt++;		
	}
	
	System.out.print("<");
	for(int i =1; i<N;i++) {
		System.out.print(queue.poll()+","+" ");
	}
		System.out.print(queue.poll()+">");
	}

}
