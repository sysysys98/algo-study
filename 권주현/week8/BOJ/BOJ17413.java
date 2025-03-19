import java.util.Scanner;
import java.util.Stack;
//단어 뒤집기1
public class BOJ17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        boolean isOk =false;

        for(int i=0; i<str.length();i++){
            char ch =str.charAt(i);
            if (ch == '<') {  // 여는 괄호이면
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop()); // 스택에 있는 단어 먼저 출력
                }
                isOk = true; //true면 괄호 안 문자로 인식하여 그냥 출력
                System.out.print(ch);
            } else if (ch == '>') {  // 닫는 괄호이면
                isOk = false;
                System.out.print(ch);
            } else if (isOk) {  // 괄호 안에 있는 문자이면
                System.out.print(ch); // 스택에 넣지 않고 그냥 출력
            } else {
                if (ch == ' ') {  // 단어가 끝난 경우
                    while (!stack.isEmpty()) {
                        System.out.print(stack.pop());
                    }
                    System.out.print(' '); // 공백 출력
                } else {  // 단어 저장 (뒤집기 위해 스택에 넣음)
                    stack.push(ch);
                }
            }
        }

        // 마지막 단어 처리
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}

