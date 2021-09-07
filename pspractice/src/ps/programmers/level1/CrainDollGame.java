package ps.programmers.level1;

import java.util.Stack;

//크레인 인형뽑기 게임 - 2019 카카오 개발자 겨울 인턴십
//20:53~21:20 = 27분
public class CrainDollGame {

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int move : moves) {
            stack.forEach(System.out::println);
            System.out.println();
            for(int i=0; i< board.length;i++){
                if(board[i][move-1]!=0){
                    if(!stack.isEmpty()) {
                        if (stack.peek() == board[i][move - 1]) {
                            stack.pop();
                            board[i][move - 1] = 0;
                            answer++;
                        } else {
                            stack.push(board[i][move - 1]);
                            board[i][move - 1] = 0;
                        }
                    }else{
                        stack.push(board[i][move - 1]);
                        board[i][move - 1] = 0;
                    }
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(new int[][] {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}},
                new int[] {1, 5, 3, 5, 1, 2, 1, 4});
    }

}
