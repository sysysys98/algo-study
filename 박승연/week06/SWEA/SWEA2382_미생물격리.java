import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA2382_미생물격리 {
    static int[] dc = {0, 0, -1, 1};
    static int[] dr = {-1, 1, 0, 0}; //상하좌우
    //배열의 모양상 위로 가려면 r idx가 -1되어야함
	
	static class Micro{ //미생물 군집 정보를 담기 위해
		int r;
		int c;
		int a;
		int d;
		int t;
		
		Micro(int r, int c, int a, int d, int t) {
			this.r = r;
			this.c = c;
			this.a = a;
			this.d = d;
			this.t = t;
		}
	}
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int tc = sc.nextInt();       

        for(int t=1; t<=tc; t++){
        	int n = sc.nextInt(); //셀 개수
        	int m = sc.nextInt(); //격리 시간
        	int k = sc.nextInt(); //군집 수
        	int time = 0; //군집에 경과 시간의 정보를 넣어줌
        	
        	List<Micro>[][] map = new ArrayList[n][n];
        	
        	for (int i = 0; i < n; i++) {
        	    for (int j = 0; j < n; j++) {
        	        map[i][j] = new ArrayList<>(); // 각 칸에 빈 List 초기화
        	    }
        	}
        	
        	for(int i=0; i<k; i++) {
        		int r = sc.nextInt(); //세로 위치
        		int c = sc.nextInt(); //가로 위치
        		int a = sc.nextInt(); //미생물 수
        		int d = sc.nextInt()-1; //이동 방향
        		
        		map[r][c].add(new Micro(r,c,a,d,time));    		
        		
        	}
        	
        	while(time<m) { //시간이 남을 때마다 계속 돌아감
	        	for(int i=0; i<n; i++) {
	        		for(int j=0; j<n; j++) {
	        			List<Micro> now = map[i][j]; //이번 칸
	        			int idx = 0;
	        			if(now.size()==0) {
	        				continue;//아무것도 없으면 넘어감
	        			}
	        			while(idx>=0 && idx<now.size()) {	
	        				Micro mc = now.get(idx); //이번 탐색할 대상
	        				if(mc.t != time) {
	        					idx++;
	        					continue; //경과처리된거면 pass
	        				}
	        				
	        				int nr = mc.r+dr[mc.d]; //다음 이동할 자리
		        			int nc = mc.c+dc[mc.d];
		        			
		        			//약물 밟았나 체크
		        			if (nr==0 || nr>n-2 || nc==0 || nc>n-2) {
		        				mc.a /= 2; //절반 삭제 
		        				if(mc.a<1){ //1마리 이하면
			        				now.remove(idx); //이번 군집은 사라짐
			        				if (now.size()==0) break; //암것도 안 남음
		        				}
		        				//이동방향 반대로 바꾸기
		        				if(mc.d==0) mc.d = 1;
		        				else if(mc.d==1) mc.d = 0;
		        				else if(mc.d==2) mc.d = 3;
		        				else mc.d = 2;		        				
		        			}
		        			
		        			//사라지는 게 아니라면 옮겨줍니다.
		        			map[nr][nc].add(new Micro(nr,nc,mc.a,mc.d,time+1));
		        			now.remove(idx); //옮겨줬으니 이전 것은 없앱니다.
	        				if (now.size()==0) break; //암것도 안 남음
		        			
	        			}
	        		}
	        	}
	        	time++; //1시간 경과 처리

                //합체 처리
	        	for(int i=0; i<n; i++) {
	        		for(int j=0; j<n; j++) {		
	        			List<Micro> now = map[i][j]; //이번 칸
	        			if(now.size()>1) {
	        				int tmp = 0;
	        				int maxA = -1;
	        				int maxD = -1;
	        				while(now.size()>0){ //1개가 되기 전까지 반복
	        					tmp += now.get(0).a; //군집 합하기
	        					if(maxA < now.get(0).a) {
	        						maxA = now.get(0).a;
	        						maxD = now.get(0).d; //군집 더 크면 방향 갱신
	        					}
	        					now.remove(0);
	        				}
	        				now.add(new Micro(i,j,tmp,maxD,time));
	        			}
	        		}	        			
	        	}
        	}
        	
        	int ans = 0;
        	for(int i=0; i<n; i++) {
        		for(int j=0; j<n; j++) {
        			List<Micro> now = map[i][j];
        			if (now.size()==0) continue;
        			for(int idx=0; idx<now.size(); idx++) {
        				ans += now.get(idx).a;
        			}        			
        		}
        	}
        	sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
