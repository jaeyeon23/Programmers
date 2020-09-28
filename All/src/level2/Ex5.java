package level2;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *  괄호 변환
 *  https://programmers.co.kr/learn/courses/30/lessons/60058
 */
public class Ex5 {

    public static void main(String[] args) {

    }

    public String solution(String p) {
        String answer = "";
        String u = "";
        String v = "";

        //1
        if(p.isEmpty()){
            return "";
        }

        for(int i = 0 ; i < p.length() - 1 ; i++){
            if(isBalance(p.substring(i, i + 1))){
                u = p.substring(i, i + 1);
                v = p.substring(i + 1, p.length());
                break;
            }
        }




        return answer;
    }

    public boolean isBalance(String str){
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0 ; i < str.length() - 1 ; i++){
            map.put(str.substring(i, i + 1), map.getOrDefault(str.substring(i, i+1), 0) + 1;
        }

        if(map.get(")") == map.get("(")){
            return true;
        }else{
            return false;
        }
    }

    public boolean isCheck(String str){
        if(isBalance(str)){
            Stack<String> stack = new Stack<>();

            for(int i = 0 ; i < str.length() - 1 ; i++){
                if("(".equals(str.substring(i, i + 1)){
                    stack.push(i);
                }
            }
            stack.push()
        }else{
            return false;
        }
    }
}
