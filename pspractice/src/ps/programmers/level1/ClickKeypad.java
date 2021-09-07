package ps.programmers.level1;

import java.util.Objects;

//키패드 누르기 - 2020 카카오 인턴십
// (쉬는시간5분) 01:53~02:51 = 53분
public class ClickKeypad {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int leftX=0, leftY=3, rightX=2, rightY=3, nowX, nowY;
        for(int i=0; i< numbers.length; i++){
            int num =(numbers[i]==0) ? 10 : numbers[i]-1;
            nowX = num % 3;
            nowY = num /3;
            if(nowX==0){
                answer += "L";
                leftX = nowX;
                leftY = nowY;
            } else if(nowX==2){
                answer += "R";
                rightX = nowX;
                rightY = nowY;
            }
            else {
                int left = Math.abs(leftX-nowX)+Math.abs(leftY-nowY);
                int right = Math.abs(rightX-nowX)+Math.abs(rightY-nowY);
                if(left>right){
                    answer += "R";
                    rightX = nowX;
                    rightY = nowY;
                }else if(left<right){
                    answer += "L";
                    leftX = nowX;
                    leftY = nowY;
                }else{
                    if(hand.equals("left")){
                        answer += "L";
                        leftX = nowX;
                        leftY = nowY;
                    }else{
                        answer += "R";
                        rightX = nowX;
                        rightY = nowY;
                    }
                }
            }
        }
        return answer;
    }

}
