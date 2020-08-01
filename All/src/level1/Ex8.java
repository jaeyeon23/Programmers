package level1;

/**
 *  서울에서 김서방 찾기
 *  https://programmers.co.kr/learn/courses/30/lessons/12919
 */
public class Ex8 {
    private static final String KIMSEOBANG="Kim";

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Jane", "Kim"}));
    }

    public static String solution(String[] seoul) {
        int val = 0;
        for(int i = 0 ; i < seoul.length ; i++){
            if(KIMSEOBANG.equals(seoul[i])){
                val = i;
                break;
            }
        }

        return "김서방은 " + Integer.toString(val) + "에 있다";
    }
}
