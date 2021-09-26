package ps.programmers.level2;

//완전탐색 - 카펫
//18:18~18:32
public class Carpet {
    public int[] solution(int brown, int yellow) {
        for(int i=1;i<=Math.sqrt(yellow);i++){
            if(yellow%i==0&&(yellow/i+i)*2+4==brown){
                return new int[]{yellow/i+2,i+2};
            }
        }
        return new int[]{};
    }
}
