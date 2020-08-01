package level1;

import java.util.Arrays;

/**
 *  문자열 내림차순으로 배치하기
 *  https://programmers.co.kr/learn/courses/30/lessons/12917
 *  StringBuilder, StringBuffer
 */
public class Ex12 {

    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }

    public static String solution(String s) {
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);

        return new StringBuilder(new String(charArr)).reverse().toString();
    }
}
