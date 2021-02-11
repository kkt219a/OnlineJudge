
/**
 *
 * [카카오인턴] 키패드 누르기 - 36분
 */

public class keypad {

    public String solution(int[] numbers, String hand) {
        int lastLeft=10;
        int lastRight=12;
        String answer = "";
        for (int number : numbers) {
            number = (number==0)?11:number;
            if(number%3==1){
                answer+="L";
                lastLeft=number;
            }else if(number%3==0){
                answer+="R";
                lastRight=number;
            }else{
                int leftDistance = Math.abs(number-lastLeft)/3+Math.abs(number-lastLeft)%3;
                int rightDistance = Math.abs(number-lastRight)/3+Math.abs(number-lastRight)%3;
                if(leftDistance<rightDistance){
                    answer+="L";
                    lastLeft = number;
                }else if(leftDistance > rightDistance){
                    answer+="R";
                    lastRight = number;
                }else{
                    if(hand.equals("left")){
                        answer+="L";
                        lastLeft = number;
                    }else{
                        answer+="R";
                        lastRight=number;
                    }
                }
            }
        }
        return answer;
    }
}
