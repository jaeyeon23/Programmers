package level1;

/**
 *  시저 암호
 *  https://programmers.co.kr/learn/courses/30/lessons/12926
 */
public class Ex14 {

    public static void main(String[] args) {
        System.out.println(solution("a B z", 4));
    }

    public static String solution(String s, int n) {
        char[] charArr = s.toCharArray();

        for(int i = 0 ; i < charArr.length ; i++){
            if(Character.isLowerCase(charArr[i])){
                charArr[i] = (int)charArr[i] + n > 'z' ? (char)(charArr[i] + n - 'z' + 'a' - 1) : (char)(charArr[i] + n);
            }else if(Character.isUpperCase(charArr[i])){
                charArr[i] = (int)charArr[i] + n > 'Z' ? (char)(charArr[i] + n - 'Z' + 'A' - 1) : (char)(charArr[i] + n);
            }
        }

        return String.valueOf(charArr);
    }
}
