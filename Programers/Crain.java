import java.util.Stack;

/**
 *
 * [2019 카카오 겨울 인턴] 크레인 인형뽑기 게임 - 25분
 */
public class Crain {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();
        int size = board[0].length;

        for (int move : moves) {
            for(int i=0;i<size;i++){
                int tmpVal = board[i][move-1];
                if(tmpVal!=0){
                    if(!bucket.empty()) {
                        if (bucket.peek().equals(tmpVal)){
                            bucket.pop();
                            answer+=2;

                        }else{
                            bucket.push(tmpVal);
                        }
                    }else {
                        bucket.push(tmpVal);
                    }
                    board[i][move-1]=0;
                    break;
                }
            }
        }

        return answer;
    }

}
