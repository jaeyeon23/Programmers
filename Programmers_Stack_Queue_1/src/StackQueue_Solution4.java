import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class StackQueue_Solution4 {
    /**
     *  프린터
     */
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int val : priorities){
            queue.offer(val);
        }

        int count = 0;
        int value = priorities[location];
        while(location >= 0 || Collections.max(queue) >= value){
           if(queue.peek() != Collections.max(queue)){
               location--;
               queue.offer(queue.poll());

               if(location == -1){
                   location = queue.size() - 1;
               }
           }else if(queue.peek() == Collections.max(queue) && location != 0){
               queue.poll();
               count++;
               location--;
           }else if(queue.peek() == Collections.max(queue) && location == 0){
               count++;
               break;
           }
        }
        return count;
    }

    public static void main(String[] args) {
        StackQueue_Solution4 solution4 = new StackQueue_Solution4();
//        solution4.solution(new int[]{2, 1, 3, 2}, 2);
        solution4.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
    }
}
