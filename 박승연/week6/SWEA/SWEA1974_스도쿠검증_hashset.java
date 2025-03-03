
import java.util.Scanner;

public class SWEA1974_스도쿠검증_hashset {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int tc = sc.nextInt();

        for(int t=1; t<=tc; t++){
            boolean flag = false;
            int[][] pz = new int[9][9];
            
            for(int i=0; i<9; i++){                
                for(int j=0; j<9; j++){
                    pz[i][j] = sc.nextInt();
                }
            }

            for(int i=0; i<9; i++){
            	int[] cnt = new int[10];
                for(int j=0; j<9; j++){
                    if(++cnt[pz[i][j]]>1) {
                    	flag = true;
                    	break;
                    }
                }
                if (flag) break;
            }
                        
            if (flag){
                sb.append("#").append(t).append(" ").append(0).append("\n");
                continue;
            }
            
            for(int i=0; i<9; i++){
            	int[] cnt = new int[10];
                for(int j=0; j<9; j++){
                    if(++cnt[pz[j][i]]>1) {
                    	flag = true;
                    	break;
                    }
                }
                if (flag) break;
            }
            
            if (flag){
                sb.append("#").append(t).append(" ").append(0).append("\n");
                continue;
            }

            
            for(int p=0; p<9; p+=3) {
            	for(int q=0; q<9; q+=3) {
                    int[] cnt = new int[10];
                    for(int i=p; i<p+3; i++){                    	
                        for(int j=q; j<q+3; j++){
                            if(++cnt[pz[i][j]]>1) {
                            	flag = true;
                            	break;
                            }
                        }
                        if (flag) break;                        
                    }
                    if (flag) break; 
            	}
            	if (flag) break; 
            }
            if (flag){
                sb.append("#").append(t).append(" ").append(0).append("\n");
            } else {
            	sb.append("#").append(t).append(" ").append(1).append("\n");
            }            
        }
        System.out.println(sb);
    }
}