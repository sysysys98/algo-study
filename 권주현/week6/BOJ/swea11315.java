package 시험대비;

import java.util.Scanner;
//오목판정
public class swea11315 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int T =sc.nextInt();
	for(int test_case=1;test_case<=T;test_case++) {
		int N =sc.nextInt();
		char[][] board = new char[N][N];
		sc.nextLine();
		for(int i=0;i<N;i++) {
			String str = sc.nextLine();
			for(int j =0;j<N;j++) {
				board[i][j] = str.charAt(j);
		}
	}
	   boolean isOk =false;
	   
	   
	 //행검사  
	 		for(int i=0;i<N;i++) {
	 			int cnt=0;
	 			for(int j =0; j<N;j++) {
	 				if(board[i][j]=='o') {
	 					cnt++;
	 				}else {
	 					cnt=0;
	 				}
	 				if(cnt >= 5) {
		 				isOk =true;	
		 				break;
		 			}
	 			}
	 			if(isOk)break;
	 		}
	 		//열검사
	 		if(!isOk) {
	 		for(int i=0;i<N;i++) {
	 			int cnt=0;
	 			for(int j =0; j<N;j++) {
	 				if(board[j][i]=='o') {
	 					cnt++;
	 				}else {
	 					cnt=0;
	 				}
	 				if(cnt >= 5) {
		 				isOk =true;	
		 				break;
		 			}
	 			}
	 			if(isOk)break;
	 		}
	 		}
	 		//대각선 검사
	 		if (!isOk) {
                for (int i = 0; i <= N - 5; i++) {
                    for (int j = 0; j <= N - 5; j++) {
                        int cnt = 0;
                        for (int k = 0; k < 5; k++) {
                            if (board[i + k][j + k] == 'o') {
                                cnt++;
                            } else {
                                break;
                            }
                        }
                        if (cnt >= 5) {
                            isOk = true;
                            break;
                        }
                    }
                    if (isOk) break;
                }
            }

            // 대각선 검사 (오른쪽 상단 -> 왼쪽 하단)
            if (!isOk) {
                for (int i = 0; i <= N - 5; i++) {
                    for (int j = 4; j < N; j++) {
                        int cnt = 0;
                        for (int k = 0; k < 5; k++) {
                            if (board[i + k][j - k] == 'o') {
                                cnt++;
                            } else {
                                break;
                            }
                        }
                        if (cnt >= 5) {
                            isOk = true;
                            break;
                        }
                    }
                    if (isOk) break;
                }
            }
	 		
	 	
	 	 if(isOk) {
	 	   System.out.println("#"+test_case+" "+"YES");
	 	}else {
	 		System.out.println("#"+test_case+" "+"NO");
	 		
	 	}
	}	
}
}
