package level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *  여행경로
 *  https://programmers.co.kr/learn/courses/30/lessons/43164?language=java
 */
public class Ex5 {
    static boolean visit[];
    static List<String> list = new ArrayList<>();
    static String route = "";

    public static void main(String[] args) {
        String[] arr = new Ex5().solution(new String[][]{{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}});

        for(String val : arr){
            System.out.println(val);
        }
    }

    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];

        for(int i = 0 ; i < tickets.length; i++) {

            String departure = tickets[i][0];
            String destination = tickets[i][1];

            if(departure.equals("ICN")) {
                visit[i] = true;
                route = departure + ",";
                dfs(tickets, destination, 1);
                visit[i] = false;
            }
        }

        Collections.sort(list);
        String[] answer = list.get(0).split(",");
        return answer;
    }

    public static void dfs(String[][] tickets, String end, int count) {

        route += end + ",";

        if(count==tickets.length) {
            list.add(route);
            return;
        }

        for(int i = 0 ; i < tickets.length ; i++) {
            String depart = tickets[i][0];
            String desti = tickets[i][1];

            if(end.equals(depart) && !visit[i]) {
                visit[i] = true;
                dfs(tickets, desti, count+1);
                visit[i] = false;
                route = route.substring(0, route.length()-4);
            }
        }
    }
}
