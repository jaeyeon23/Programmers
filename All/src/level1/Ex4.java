package level1;

import java.util.Calendar;

/**
 *  2016년
 *  https://programmers.co.kr/learn/courses/30/lessons/12901?language=java
 */
public class Ex4 {
    public static void main(String[] args) {
        System.out.println(solution(5, 24));
    }

    public static String solution(int a, int b){
        String[] arr = {"SUN","MON","TUE","WED","THU","FRI","SAT"};

        Calendar cal = Calendar.getInstance();
        cal.set(2016, a - 1, b);
        int val = cal.get(Calendar.DAY_OF_WEEK) - 1;

        return arr[val];
    }
}
