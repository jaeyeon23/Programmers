import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *  힙 - 더 맵게
 */
public class Heap1 {

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.stream(scoville).boxed().collect(Collectors.toList()));

        while(list.size() >= 2 && list.get(0) < K){
            list.add(list.get(0) + (list.get(1) * 2));
            list.remove(1);
            list.remove(0);
            list.sort(Integer::compareTo);
            answer++;
        }

        if(list.size() == 1 && list.get(0) < K){
            answer = -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}
