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
        List<Integer> list = new ArrayList<>();
        Queue<Integer> work = new LinkedList<>();
        Queue<Integer> workSpeed = new LinkedList<>();
        for(int p : progresses){
            work.offer(p);
        }

        for(int s : speeds){
            workSpeed.offer(s);
        }

        int count = 0;
        int old_time = 100;
        while(!work.isEmpty()){
            if(work.peek() < 100) {
                int time = 0;
                time = (100 - work.poll()) / workSpeed.poll();
                if(old_time >= time){
                    count++;
                    old_time = time;
                }else{
                    list.add(count);
                    count = 0;
                }
            }
        }

        if(count != 0){
            list.add(count);
        }

        // int형 배열로 변환
        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        StackQueue_Solution3 solution3 = new StackQueue_Solution3();
        int[] answer = solution3.solution(new int[]{93,30,55}, new int[]{1,30,5});

        for(int value : answer){
            System.out.println(value);
        }
    }
}
