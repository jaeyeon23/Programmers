import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  기능개발
 */
public class StackQueue_Solution3 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> answerQueue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        int value = 0;
        int count = 0;
        for(int i = 0 ; i < progresses.length ; i++){
            int time = 0;

            time = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);

            if(value == 0){
                value = time;
                count++;
            }else if(value >= time){
                count++;
            }else{
                answerQueue.offer(count);
                value = time;
                count = 1;
            }

            if(i == progresses.length - 1){
                answerQueue.offer(count);
            }

        }

        answer = new int[answerQueue.size()];
        for(int j = 0 ; j < answer.length ; j++){
            if(!answerQueue.isEmpty()) {
                answer[j] = answerQueue.poll();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        StackQueue_Solution3 solution3 = new StackQueue_Solution3();
        int[] answer = solution3.solution(new int[]{54,33,56}, new int[]{20,13,1});

        for(int value : answer){
            System.out.println(value);
        }
    }
}
