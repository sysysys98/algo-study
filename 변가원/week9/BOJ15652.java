import java.util.Scanner;

public class BOJ15652 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr =  new int[M];
        sb = new StringBuilder();

        function(1, 0);
        System.out.println(sb);
    }

    public static void function(int start, int depth) {
        if (depth == M) {  // M개의 숫자가 모두 배열에 저장되었그면
            for (int tmp : arr) {  // 배열에 저장된 숫자를 sb에 추가
                sb.append(tmp).append(" ");
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i <= N; i++) {  // start부터 N까지 반복하여 숫자 배열에 저장
            arr[depth] = i;
            function(i, depth + 1);
        }
    }
}
