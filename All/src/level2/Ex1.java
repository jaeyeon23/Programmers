package level2;

/**
 * 문자열 압축
 * https://programmers.co.kr/learn/courses/30/lessons/60057?language=java
 */
public class Ex1 {
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }

    public static int solution(String s) {
        int answer = s.length();

        if (s.length() == 1)
            return 1;

        for (int i = 1; i <= s.length() / 2; i++) { //비교 갯수 지정
            int count = 1;
            String f = s.substring(0, i);
            String cmp, cp = "";

            for (int j = i; j < s.length(); j += i) { //처음부터 쭉 비교하기
                if(j + i < s.length()) {
                    cmp = s.substring(j, j + i);
                }else{
                    cmp = s.substring(j);
                }

                if (f.equals(cmp))  //비교 문자가 같으면 count 증가
                    count++;
                else {
                    if (count == 1) {
                        cp += f;
                        f = cmp;
                    } else {
                        cp = cp + Integer.toString(count) + f;
                        f = cmp;
                        count = 1;
                    }
                }

                if (j + i >= s.length()) {  //마지막에 substr기준을 초과한 경우
                    if (count != 1) {
                        cp = cp + Integer.toString(count) + f;
                        break;
                    } else {
                        cp = cp + s.substring(j);
                        break;
                    }
                }
            }
            answer = Math.min(answer, cp.length());
        }

        return answer;
    }
}


