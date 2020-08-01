package level1;

/**
 *  문자열 다루기 기본
 *  https://programmers.co.kr/learn/courses/30/lessons/12918
 *  정규표현식 공부 -> s.matchers("^[0-9]{4}|{6}$")
 */
public class Ex11 {
    public static void main(String[] args) {
        System.out.println(solution("1234"));
    }

    public static boolean solution(String s) {
        if(s.length() == 4 || s.length() == 6){
            for(int i = 0 ; i < s.length() ; i++){
                if(Character.isDigit(s.charAt(i))){
                    continue;
                }else{
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }
    }
}
