
public class Solution2 {

	public boolean solution(String[] phone_book) {
		boolean answer = true;
		
		for(int i = 0 ; i < phone_book.length ; i++) {
			for(int j = 0 ; j < phone_book.length ; j++) {
				if(i != j && phone_book[j].startsWith(phone_book[i])) {
					return false;
				}
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		String[] phone_book = {"123", "456", "789"};
		
		System.out.println(solution.solution(phone_book));
	}

}
