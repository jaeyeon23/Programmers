import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution1 {

	public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(String part : participant) {
        	map.put(part, map.getOrDefault(part, 0) + 1);
        }
        
        for(String comp : completion) {
        	map.put(comp, map.get(comp) - 1);
        }
        
        for(Entry<String, Integer> entry : map.entrySet()) {
        	if(entry.getValue() > 0) {
        		answer = entry.getKey();
        		break;
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		Solution1 solution = new Solution1();
		String[] participant = { "mislav", "stanko", "mislav", "ana" };
		String[] completion = { "stanko", "ana", "mislav" };

		System.out.println(solution.solution(participant, completion));
	}

}
