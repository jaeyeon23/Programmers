package level3;

import java.util.*;

/**
 * 네트워크
 * https://programmers.co.kr/learn/courses/30/lessons/43162?language=java
 */
public class Ex3 {
    public static void main(String[] args) {
        System.out.println(new Ex3().solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] arr = new boolean[n];

        int i = 0;
        while(i != n){
            arr[i] = true;
            for(int j = 0 ; j < computers[i].length ; j++){
                if(i != j && arr[j] == false && !queue.contains(j) && computers[i][j] == 1){
                    queue.offer(j);
                }
            }

            if(queue.isEmpty()){
                answer++;
                int tmp = i;
                for(int k = 1 ; k < n ; k++){
                    if(arr[k] == false) {
                        i = k;
                        break;
                    }
                }

                if(i == tmp){
                    i = n;
                }
            }else{
                i = queue.poll();
            }
        }

        return answer;
    }
}
