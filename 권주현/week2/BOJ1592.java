import java.util.Scanner;
//영식이와 친구들
public class BOJ1592 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        int[] array = new int[N];
        int count =0;
        int idx =0;
        while(true){
            ++array[idx]; //받자마자 1 추가
            if(array[idx] ==M) break; //조건에 맞으면 break
            if(array[idx]%2==1) {  //홀수인경우
                if(idx+L<array.length){  //인덱스 안넘어가면 시계방향
                    count++;
                    idx+=L;
                }else{
                    count++;
                    idx = idx + L- array.length; //인덱스 범위 넘어가는 경우
                }
            }else{
                if(idx-L>=0){ //인덱스 안넘어가는 경우
                    count++;
                    idx-=L; // 반시계방향
                }else{
                    count++;
                    idx =idx -L+ array.length; //인덱스 범위 넘어가는 경우
                }
            }
        }
        System.out.println(count);
        sc.close();
    }
}
