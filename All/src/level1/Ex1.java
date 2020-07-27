package level1;

/**
 *  가운데 글자 가져오기
 *  https://programmers.co.kr/learn/courses/30/lessons/12903
 */
public class Ex1 {
    public static void main(String[] args) {
        System.out.println(new Ex1().solution("abcde"));
        System.out.println(new Ex1().solution("qwer"));
    }

    public String solution(String s) {
        String answer = "";

        if(s.length() != 0) {
            answer = s.substring((s.length() - 1) / 2, s.length() / 2 + 1);
        }

        return answer;
    }
}
