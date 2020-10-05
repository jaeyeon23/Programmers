package level2;

/**
 *  괄호 변환
 *  https://programmers.co.kr/learn/courses/30/lessons/60058
 */
public class Ex5 {

    public static void main(String[] args) {
        System.out.println(new Ex5().solution("()))((()"));
    }

    public StringBuilder solution(String p) {
        StringBuilder u = new StringBuilder("");
        StringBuilder v = new StringBuilder("");
        int open = 0;
        int close = 0;

        //1
        if(p.isEmpty()){
            return new StringBuilder("");
        }

        //2
        for(int i = 0 ; i < p.length() ; i++){
            if(p.charAt(i) == '('){
                open++;
            }else{
                close++;
            }

            if(open == close){
                u.append(p.substring(0, i + 1));
                v.append(p.substring(i + 1));
                break;
            }
        }

        if(!"".equals(v.toString())){
            v = solution(v.toString());
        }

        if(isCheck(u)){
            u.append(solution(v.toString()));
            return u;
        }else{
            StringBuilder tmp = new StringBuilder("");
            tmp.append("(" + v.toString() + ")");
            for(int i = 1 ; i < u.length() - 1 ; i++){
                if(u.charAt(i) == ')'){
                    tmp.append("(");
                }else{
                    tmp.append(")");
                }
            }
            return tmp;
        }
    }

    public boolean isCheck(StringBuilder str){
        if(str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')'){
            return true;
        }else{
            return false;
        }
    }
}
