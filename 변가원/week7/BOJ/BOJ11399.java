import java.util.Arrays;
import java.util.Scanner;

public class BOJ11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] line = new int[n];  // 인출하는데 걸리는 시간

        for (int i = 0; i < n; i++) {
            line[i] = sc.nextInt();
        }

        Arrays.sort(line);  // 오름차순 정렬

        int sum = 0;  // 총 걸리는 시간
        int add = 0;  // 더할 시간

        for (int i = 0; i < n; i++) {
            add += line[i];
            sum += add;
        }

        System.out.println(sum);
    }
}
