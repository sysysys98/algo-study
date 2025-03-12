package 시험대비;

import java.util.Scanner;

public class BOJ1018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M =sc.nextInt();
        int N=sc.nextInt();
        sc.nextLine();
        char[][] board = new char[M][N];
        for(int i =0;i<M;i++){
            String str = sc.nextLine();
            for(int j =0;j<N;j++){
                board[i][j] = str.charAt(j);
            }
        }

        int min =M*N;
        for(int i =0;i<M-7;i++){
            for(int j =0;j<N-7;j++){

                    int w_cnt = 0;
                    for(int r =0; r<8;r++){
                        for(int c=0;c<8;c++){
                            if(r%2==0 && c%2==0){
                                if(board[i+r][j+c]=='B') w_cnt++;
                            }else if(r%2==0 && c%2==1){
                                if(board[i+r][j+c]=='W') w_cnt++;
                            }else if(r%2==1 && c%2==0){
                                if(board[i+r][j+c]=='W') w_cnt++;
                            }else{
                                if(board[i+r][j+c]=='B') w_cnt++;
                            }
                        }
                    }
                    if(w_cnt<min) min =w_cnt;


                    int b_cnt =0;
                    for(int r =0; r<8;r++){
                        for(int c=0;c<8;c++){
                            if(r%2==0 && c%2==0){
                                if(board[i+r][j+c]=='W') b_cnt++;
                            }else if(r%2==0 && c%2==1){
                                if(board[i+r][j+c]=='B') b_cnt++;
                            }else if(r%2==1 && c%2==0){
                                if(board[i+r][j+c]=='B') b_cnt++;
                            }else{
                                if(board[i+r][j+c]=='W') b_cnt++;
                            }
                        }
                    }

                if(b_cnt<min) min = b_cnt;
                }

            }



        System.out.println(min);
        }


    }

