package level2;

/**
 *  타겟 넘버
 *  https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
 */
public class Ex2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;

        return DFS(numbers, target, 0, 0);
    }

    public static int DFS(int[] numbers, int target, int node, int num){
        if(node == numbers.length){
            return num == target ? 1 : 0;
        }else{
            return DFS(numbers, target, node + 1, num + numbers[node])
                    + DFS(numbers, target, node + 1, num - numbers[node]);
        }
    }
}
