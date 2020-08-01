package level1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *  소수 찾기
 *  https://programmers.co.kr/learn/courses/30/lessons/12921
 */
public class Ex7 {
    public static void main(String[] args) {
        System.out.println(solution(10));
        //2,3,5,7
    }

    public static int solution(int n) {
        int[] arr = new int[n+1];
        int val = 2;

        int answer = 0;

        for(int i = 2 ; i < arr.length ; i++){
            arr[i] = val++;
        }

        for(int i = 2 ; i < Math.sqrt(n) ; i++){
            if(arr[i] == 0){
                continue;
            }else{
                for(int j = i+i ; j < arr.length ; j += i){
                    arr[j] = 0;
                }
            }
        }

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != 0){
                answer++;
            }
        }

        return answer;
    }
}
