package level1;

import java.util.ArrayList;
import java.util.List;

/**
 *  크레인 인형뽑기 게임
 *  https://programmers.co.kr/learn/courses/30/lessons/64061
 */
public class Ex3 {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        int val = solution(board, moves);
        System.out.println(val);
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < moves.length ; i++){
            for(int j = 0 ; j < board.length ;j++){
                if(board[j][moves[i] - 1] != 0){
                    list.add(board[j][moves[i] - 1]);
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }

            if(list.size() >= 2) {
                for (int k = 0; k < list.size() - 1; k++) {
                    if (list.get(k) == list.get(k + 1)) {
                        list.remove(k + 1);
                        list.remove(k);
                        answer += 2;
                    }
                }
            }
        }

        return answer;
    }
}
