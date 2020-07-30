package level1;

import java.util.ArrayList;
import java.util.List;

/**
 *  나누어 떨어지는 숫자 배열
 *  https://programmers.co.kr/learn/courses/30/lessons/12910
 */
public class Ex6 {
    public static void main(String[] args) {
        solution(new int[]{5, 9, 7, 10}, 5);
        solution(new int[]{2, 36, 1, 3}, 1);
        solution(new int[]{3,2,6}, 10);
    }

    public static int[] solution(int[] arr, int divisor) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] % divisor == 0){
                list.add(arr[i]);
            }
        }

        if(list.size() == 0){
            answer = new int[1];
            answer[0] = -1;
        }else{
            list.sort((o1, o2) -> o1.compareTo(o2));
            answer = list.stream().mapToInt(i->i).toArray();
        }

        return answer;
    }
}
