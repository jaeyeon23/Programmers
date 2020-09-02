package level2;

/**
 *  카펫
 *  https://programmers.co.kr/learn/courses/30/lessons/42842?language=java
 */
public class Ex4 {

    public static void main(String[] args) {
        int[] answer = solution(10, 2);
        for(int val : answer){
            System.out.print(val + " ");
        }
    }

    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int brown_temp = brown + 4;

        int result = 0;
        if(brown_temp % 4 == 0){
            int val = brown_temp / 4;
            answer[0] = val;
            answer[1] = val;

            while(true){
                result = answer[0] * answer[1];
                if(yellow == result - brown){
                    break;
                }else{
                    answer[0] += 1;
                    answer[1] -= 1;
                }
            }
        }else if(brown_temp / 4 != 0){
            int val = brown_temp / 4;
            answer[0] = val + 1;
            answer[1] = val;

            while(true){
                result = answer[0] * answer[1];
                if(yellow == result - brown){
                    break;
                }else{
                    answer[0] += 1;
                    answer[1] -= 1;
                }
            }
        }

        return answer;
    }
}
