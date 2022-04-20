package ps.programmers.level1.crain_dollGame;

import java.util.Stack;

//크레인 인형뽑기 게임 - 2019 카카오 개발자 겨울 인턴십
// 2022/04/20 12:00 ~ 12:10 = 10분
public class CrainDollGameV2 {
    Stack<Integer> s = new Stack<>();
    int ans = 0;
    public int solution(int[][] board, int[] moves) {
        for (int move : moves) {
            for(int i=0;i< board.length;i++) {
                if(board[i][move-1] !=0) {
                    inputBascket(board[i][move-1]);
                    board[i][move-1]=0;
                }
            }
        }
        return ans;
    }

    private void inputBascket(int value) {
        if(!s.isEmpty() && s.peek() == value){
            s.pop();
            ans+=2;
        } else {
            s.push(value);
        }
    }

}
