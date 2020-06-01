import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  완전탐색 - 모의고사
 */
public class BruteForceSearch1 {
    public static int[] solution(int[] answers){
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {2,1,2,3,2,4,2,5};
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5};

        Map<Integer, Integer> maxList = new HashMap<>();

        maxList.put(0,0);
        maxList.put(1,0);
        maxList.put(2,0);

        for (int i = 0; i < answers.length; i++) {

            if(answers[i] == arr1[i % arr1.length]) {
                maxList.replace(0, maxList.get(0)+1);
            }

            if(answers[i] == arr2[i % arr2.length]) {
                maxList.replace(1, maxList.get(1)+1);
            }

            if(answers[i] == arr3[i % arr3.length]) {
                maxList.replace(2, maxList.get(2)+1);
            }

        }

        int max = maxList.get(0);

        if(maxList.get(1) < maxList.get(2)) {

            if(max < maxList.get(2)) {
                max = maxList.get(2);
            }
        } else {
            if(max < maxList.get(1)) {
                max = maxList.get(1);
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < maxList.size(); i++) {
            if(max == maxList.get(i)) {
                answer.add(i+1);
            }
        }

        return answer.stream().filter(i -> i != null).mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] answer = solution(new int[]{1,2,3,4,5});

        for(int val : answer){
            System.out.print(val + " ");
        }
    }
}
