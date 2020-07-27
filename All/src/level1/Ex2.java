package level1;

import java.util.Arrays;

/**
 * 문자열 내 마음대로 정렬하기
 * https://programmers.co.kr/learn/courses/30/lessons/12915
 */
public class Ex2 {
    public static void main(String[] args) {
        String[] str = new Ex2().solution(new String[]{"sun", "bed", "car"}, 1);
        for(String val : str){
            System.out.println(val);
        }

        String[] str2 = new Ex2().solution(new String[]{"abce", "abcd", "cdx"}, 2);
        for(String val : str2){
            System.out.println(val);
        }
    }

    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            if(o1.substring(n, n+1).compareTo(o2.substring(n, n+1)) == 0){
                return o1.compareTo(o2);
            }else{
                return o1.substring(n, n+1).compareTo(o2.substring(n, n+1));
            }
        });

        return strings;
    }
}
