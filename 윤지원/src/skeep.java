import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * 유진아 기억 나네..? 우리가 머리 붙잡고 푼 문제 있잖아.....정말 힘들었어.
 * 결국 시간 초과 안 나려면 스택에 문자열들을 숫자로 치환해서 추가를 했었어야 했다. char 추가와 숫자 추가가 이렇게
 * 시간이 많이 차이가 날 줄은 몰랐다!!
 */
public class skeep {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 's':
                    stack.addLast(1);
                    break;

                case 'k':
                    if (!stack.isEmpty() && stack.peekLast() == 1) {
                        stack.addLast(stack.pollLast() + 1);
                    } else {
                        stack.clear();
                    }
                    break;

                case 'e':
                    if (!stack.isEmpty() && (stack.peekLast() == 2 || stack.peekLast() == 3)) {
                        stack.addLast(stack.pollLast() + 1);
                    } else {
                        stack.clear();
                    }
                    break;

                case 'p':
                    if (!stack.isEmpty() && stack.peekLast() == 4) {
                        stack.addLast(stack.pollLast() + 1);
                    } else {
                        stack.clear();
                    }
                    break;

                default:
                    stack.clear();
                    break;
            }

            while (!stack.isEmpty() && stack.peekLast() == 5) {
                stack.pollLast();
                ans++;

                if (!stack.isEmpty()) {
                    stack.addLast(stack.pollLast() + 1);
                }
            }
        }

        System.out.println(ans);
    }

}