package level1;

/**
 *  체육복
 *  https://programmers.co.kr/learn/courses/30/lessons/42862?language=java
 */
public class Ex16 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int lostCount = 0;
        int count = 0;

        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    lostCount++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j] + 1 || lost[i] == reserve[j] - 1) {
                    count++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        answer = n - lost.length + lostCount + count;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Ex16().solution(3, new int[]{3}, new int[]{1}));
    }



    /*
        int[] people = new int[n];
        int answer = n;

        for (int l : lost)
            people[l-1]--;
        for (int r : reserve)
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else
                    answer--;
            }
        }
        return answer;
     */
}
