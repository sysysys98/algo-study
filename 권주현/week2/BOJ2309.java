import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//일곱난쟁이
public class BOJ2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[9];
        for(int i =0; i<array.length;i++){
            array[i]=sc.nextInt();
        }
        int sum =0;
        for(int i=0;i< array.length;i++){
            sum+=array[i];
        }
        int a =0;
        int b=0;
        int k= sum-100; //가짜 두명 합
        for(int i =0; i< array.length;i++){ //이중 for문 돌면서 가짜 두명있는 인덱스 a, b에 저장
            for(int j=i+1;j< array.length;j++){
                if(array[i]+array[j]==k){
                    a =i;  
                    b=j;
                    break;
                }
            }
        }
        List<Integer> list = new ArrayList<>(); //새로운 list선언
        for(int i=0;i< array.length; i++){
            if(i !=a && i !=b){ //가짜 두명 뺴고 list에 추가
             list.add(array[i]);
            }
        }
        Collections.sort(list); //오름차순 정렬
        for(int num : list){
            System.out.println(num);
        }
        sc.close();
    }
}
