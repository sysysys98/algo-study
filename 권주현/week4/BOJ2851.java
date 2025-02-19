import java.util.Scanner;
//슈퍼마리오
public class BOJ2851 {
	public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int[] arr =new int[10];
        for(int i=0;i<10;i++){
            arr[i]= sc.nextInt();
        }
        int sum1=0;
        int idx =0;
       for(int i=0;i<10;i++){
           sum1+=arr[i];
          if(sum1>=100){  //100보다 같거나 큰 경우 break
              idx=i;
              break;
          }
       }
       int diff1=sum1-100;
        int sum2=0;
        for(int i=0;i<idx;i++){
            sum2+=arr[i];      //앞에서 break한 idx의 전idx까지 합 구함
        }
        int diff2=100-sum2;

        if(diff1>diff2){
            System.out.println(sum2);
        }else{
            System.out.println(sum1);
        }
        sc.close();
    }


}
