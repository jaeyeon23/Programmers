import java.util.Arrays;
import java.util.Comparator;

public class Sort_Solution2 {

	public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] val = new String[numbers.length];
        
        for(int i = 0 ; i < numbers.length ; i++) {
        	val[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(val, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
        	
		});
        
        for(String result : val) {
        	answer.append(result);
        }
        
        return answer.toString().startsWith("0") ? "0" : answer.toString();
    }
	
	public static void main(String[] args) {
		Sort_Solution2 solution = new Sort_Solution2();
		int[] numbers = {3, 30, 34, 5, 9};
		System.out.println(solution.solution(numbers));
	}
}
