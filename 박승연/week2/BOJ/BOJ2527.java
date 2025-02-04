import java.io.IOException;
import java.util.Scanner;

public class BOJ2527 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int p1 = sc.nextInt();
            int q1 = sc.nextInt();

            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int p2 = sc.nextInt();
            int q2 = sc.nextInt();

            if (p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) {
                sb.append("d").append("\n");
            }

            else if ((p1 == x2 && q1 == y2) || (p1 == x2 && y1 == q2) ||
                     (p2 == x1 && q1 == y2) || (p2 == x1 && y1 == q2)) {
                sb.append("c").append("\n");
            }

            else if ((p1 == x2 || p2 == x1) && (y1 < q2 && q1 > y2)) {
                sb.append("b").append("\n");
            } else if ((q1 == y2 || q2 == y1) && (x1 < p2 && p1 > x2)) {
                sb.append("b").append("\n");
            }

            else {
                sb.append("a").append("\n");
            }
        }

        System.out.println(sb);
    }
}
