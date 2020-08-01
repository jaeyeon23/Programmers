package level1;

/**
 *  문자열 내 p와 y의 개수
 *  https://programmers.co.kr/learn/courses/30/lessons/12916
 *  람다식이란...
 */
public class Ex10 {

    public static void main(String[] args) {
        System.out.println(solution("pPoooY"));
    }

    public static boolean solution(String s) {
        int countP = 0;
        int countY = 0;

        s = s.toUpperCase();

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == 'P')
                countP++;
            else if(s.charAt(i) == 'Y')
                countY++;
            else
                continue;
        }

        if(countP == countY){
            return true;
        }else{
            return false;
        }
    }
}
