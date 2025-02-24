import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10158 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  // Scanner를 사용하면 에러가 남
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());  // 가로 길이
        int h = Integer.parseInt(st.nextToken());  // 세로 길이

        st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());  // 개미의 초기 좌표값
        int q = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());  // 시간

        // 개미는 t초 후에 x축으로 p + t, y축으로 q + t만큼 이동
        // 개미가 오른쪽 벽에 도달한 후 다시 왼쪽으로 돌아오는 주기는 2*w
        // 직사각형을 넘어가면 재계산

        p = (p+t) % (2*w);
        q = (q+t) % (2*h);

        if(p > w) p = w - (p-w);
        if(q > h) q = h - (q-h);

        System.out.println(p + " "+ q);
    }

}