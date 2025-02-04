import java.util.Scanner;
// 스위치 켜고 끄기
public class BOJ1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int switch_cnt = sc.nextInt();
        int[] array = new int[switch_cnt];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        int student_cnt = sc.nextInt();
        for (int i = 0; i < student_cnt; i++) {
            int a = sc.nextInt(); // 1이 입력이면 남자, 2이 입력이면 여자
            int b = sc.nextInt();
            int idx = b - 1; //배열 인덱스는 0부터 시작이므로
            int k = 1;
            if (a == 1) { //남자인 경우
                while (true) {
                    if (idx >= array.length) break; //idx가 범위를 벗어나면 break
                    if (array[idx] == 0) {
                        array[idx] = 1;
                    } else {
                        array[idx] = 0;
                    }
                    idx += b;//배수이므로
                }
            } else { //여자인 경우
                if (array[idx] == 0) {
                    array[idx] = 1;
                } else {
                    array[idx] = 0;
                }
                while (true) {
                    if (idx - k < 0 || idx + k >=array.length) break; //인덱스가 범위 밖이면 break
                    if (array[idx - k] == array[idx + k]) { //주위랑 비교해서 같으면
                        if (array[idx - k] == 1) {
                            array[idx - k] = 0;
                            array[idx + k] = 0;
                        } else {
                            array[idx - k] = 1;
                            array[idx + k] = 1;
                        }
                        k++; //1칸씩 옆으로 넓혀가면서  while문 반복
                    } else {
                        break;
                    }
                }
            }
        }
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j]);
            if ((j + 1) % 20 == 0 && j != array.length - 1) { // 20넘으면 줄 바꿈 아니면 공백
                System.out.println();
            } else {
                System.out.print(" ");
            }
        }
        sc.close();
    }
    }

