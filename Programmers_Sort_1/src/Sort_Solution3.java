import java.util.Arrays;

public class Sort_Solution3 {

	public int solution(int[] citations) {
		int answer = 0;
        Arrays.sort(citations);
 
        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
 
            if (citations[i] >= h) {
                return h;
            }
        }

        return answer;
    }
	
	public static void main(String[] args) {
		Sort_Solution3 solution = new Sort_Solution3();
//		int[] citations = {3, 0, 6, 1, 5};
		int[] citations = {1,7,0,1,6,4};
		
		System.out.println(solution.solution(citations));
	}

}
