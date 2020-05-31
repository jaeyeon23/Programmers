/**
 *  주식가격
 */
public class StackQueue_Solution6 {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int count = 0;

        for(int i = 0 ; i < prices.length ; i++){
            for(int j = i + 1 ; j < prices.length ; j++){
                count++;
                if(prices[i] > prices[j]){
                    break;
                }
            }
            answer[i] = count;
            count = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
//        int[] answer = solution(new int[]{1, 2, 3, 2, 3});
        int[] answer = solution(new int[]{1,2,4,5,3,3,2,4,1});

        for(int val : answer){
            System.out.print(val + " ");
        }
    }
}
