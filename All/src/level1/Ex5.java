package level1;

import java.util.ArrayList;
import java.util.List;

/**
 *  같은 숫자는 싫어
 *  https://programmers.co.kr/learn/courses/30/lessons/12906
 */
public class Ex5 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] result = solution(arr);

        for(int val : result){
            System.out.println(val);
        }
    }

    public static int[] solution(int[] arr){
        int[] answer = {};

        List<Integer> list = new ArrayList<>();

        list.add(arr[0]);

        for(int i = 1 ; i < arr.length ; i++){
            if(list.get(list.size() - 1) != arr[i]){
                list.add(arr[i]);
            }
        }

        answer = list.stream().mapToInt(i->i).toArray();

        return answer;
    }
}
