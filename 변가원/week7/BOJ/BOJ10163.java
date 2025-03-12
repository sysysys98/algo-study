import java.util.Scanner;

public class BOJ10163 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[1001][1001];  // 색종이가 놓이는 평면

        for (int i = 1; i <= n; i++) {
            int x = sc.nextInt();  // x좌표
            int y = sc.nextInt();  // y좌표
            int w = sc.nextInt();  // 너비
            int h = sc.nextInt();  // 높이

            for (int j = x; j < x + w; j++) {  // 색종이가 놓인 곳에 해당하는 번호 넣기
                for (int k = y; k < y + h; k++) {
                    arr[j][k] = i;
                }
            }

        }

        for (int i = 1; i <= n; i++) {  // 해당하는 번호의 카운트 세기
            int cnt = 0;
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr[j].length; k++) {
                    if (arr[j][k] == i) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }

    }
}
