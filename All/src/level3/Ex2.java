package level3;

/**
 *  자물쇠와 열쇠
 *  https://programmers.co.kr/learn/courses/30/lessons/60059
 */
public class Ex2 {
    public static void main(String[] args) {

    }

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        int key_len = key.length;
        int lock_len = lock.length;
        int[][] temp = new int[key_len + lock_len][key_len + lock_len];

        for(int i = 0 ; i < lock.length ; i++){
            for(int j = 0 ; j < lock.length ; j++){
                temp[key_len + i][key_len + j] = lock[i][j];
            }
        }

        dfs(key, temp, 0);

        return answer;
    }

    public void dfs(int[][] key, int[][] temp, int cnt){


        if(cnt >= 4){
            break;
        }else{
            dfs(rotate(key), temp, cnt++);
        }
    }

    public int[][] rotate(int[][] key){
        int len = key.length;
        int[][] result = new int[len][len];

        for(int i = 0 ; i < len ; i++){
            for(int j = 0 ; j < len ; j++){
                result[i][j] = key[len - j - 1][i];
            }
        }

        return result;
    }
}
