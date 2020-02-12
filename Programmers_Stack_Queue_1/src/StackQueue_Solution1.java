
public class StackQueue_Solution1 {

	public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		
		answer[0] = 0;
		
		for(int i = 1 ; i < heights.length ; i++) {
			for(int j = i - 1 ; j >= 0 ; j--) {
				if(heights[i] < heights[j]) {
					answer[i] = j + 1;
					break;
				}
				
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		StackQueue_Solution1 solution = new StackQueue_Solution1();
		int[] heights = {1,5,3,6,7,6,5};
		int[] answers = solution.solution(heights);
		
		for(int answer : answers) {
			System.out.print(answer + " ");
		}
	}

}
