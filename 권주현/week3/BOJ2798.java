import java.util.Scanner;
//블랙잭
public class BOJ2798 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for(int i =0; i< arr.length;i++){
            arr[i] = sc.nextInt();
        }
        int sum =0; //세개 합
        int diff =0; //M과의 차
        int min_diff= M; //M과 가까운 세개의 합을 구하기 위한 min 차이
        for(int i=0;i<arr.length-2;i++){
            for(int j =i+1;j< arr.length-1;j++){
                for(int k =j+1;k< arr.length;k++){  //모든 경우의 수
                    sum =arr[i]+arr[j]+arr[k];
                    diff =M-sum; //차이
                    if(diff<0){ //세개의 합이 M보다 크면 continue
                        continue;
                    }else{
                        if(diff<min_diff){
                            min_diff =diff;  //최소 차를 모든 경우의 수를 돌면서 구함
                        }else{
                            continue; //이미 저장된 min_diff가 현재 계산된 diff보다 작은 경우 continue
                        }
                }
            }
        }
    }
        System.out.println(M-min_diff);
}
}

