package level1;

/**
 *  두 정수 사이의 합
 *  https://programmers.co.kr/learn/courses/30/lessons/12912
 *  등차수열 합 공식 -> (b - a + 1) * (a + b) / 2;
 */
public class Ex9 {
    public static void main(String[] args) {
        System.out.println(solution(5, 3));
    }

    public static long solution(int a, int b) {
        long answer = 0;

        if(a == b){
            return a;
        }else if(a > b){
            while(b != a+1){
                answer += b++;
            }
        }else{
            while(a != b+1){
                answer += a++;
            }
        }

        return answer;
    }
}
