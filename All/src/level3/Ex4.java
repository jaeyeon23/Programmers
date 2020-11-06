package level3;

/**
 *  단어 변환
 *  https://programmers.co.kr/learn/courses/30/lessons/43163?language=java
 */
public class Ex4 {

    int answer = 51;
    boolean checkWordsArr[];

    public static void main(String[] args) {
        System.out.println(new Ex4().solution("hit", "cog", new String[]{"hot","dot","dog","lot","log","cog"}));
    }

    public int solution(String begin, String target, String[] words) {
        if(checkTarget(target, words)){
            checkWordsArr = new boolean[words.length];
            DFS(begin, target, words, 0);
        }else{
            return 0;
        }

        return answer;
    }

    protected void DFS(String begin, String target, String[] words, int count){
        if(begin.equals(target)){
            answer = answer < count ? answer : count;
        }else{
            for(int i = 0 ; i < words.length ; i++){
                if(!checkWordsArr[i] && checkWord(begin, words[i])){
                    checkWordsArr[i] = true;
                    DFS(words[i], target, words, count+1);
                    checkWordsArr[i] = false;
                }
            }
        }
    }

    protected boolean checkTarget(String target, String[] words){
        for(String value : words){
            if(value.equals(target)){
                return true;
            }
        }
        return false;
    }

    protected boolean checkWord(String begin, String word){
        int count = 0;
        for(int j = 0 ; j < begin.length() ; j++){
            if(begin.charAt(j) == word.charAt(j)){
                count++;
            }
        }

        return count == begin.length() - 1 ? true : false;
    }
}
