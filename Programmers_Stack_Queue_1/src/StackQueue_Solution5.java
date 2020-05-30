import java.util.Stack;

/**
 *  20.05.30 쇠막대기
 */
public class StackQueue_Solution5 {

    public static int solution(String arrangement) {
        int answer = 0;
        char before = ' ';
        char ch[] = arrangement.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(char val : ch){
            if(val == '('){
                stack.push(val);
            }else{
                if(before == ')'){
                    stack.pop();
                    answer += 1;
                }else{
                    stack.pop();
                    answer += stack.size();
                }
            }
            before = val;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("()(((()())(())()))(())"));
    }
}
