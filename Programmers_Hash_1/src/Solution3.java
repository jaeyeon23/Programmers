import java.util.HashMap;
import java.util.Map;

public class Solution3 {

	public int solution(String[][] clothes) {
		int answer = 1;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i = 0 ; i < clothes.length ; i++) {
			map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
		}
		
		for(int value : map.values()) {
			answer *= (value + 1);
		}
		
		
		return answer - 1;
	}
	
	public static void main(String[] args) {
		Solution3 solution = new Solution3();
		String[][] clothes = {{"yellow_hat", "headgear"},
				{"blue_sunglasses", "eyewear"},
				{"green_turban", "headgear"}};
		
		System.out.println(solution.solution(clothes));
		
	}

}
