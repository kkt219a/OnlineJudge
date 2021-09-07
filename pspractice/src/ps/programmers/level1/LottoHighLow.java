package ps.programmers.level1;

import java.util.Arrays;

// 2021 Dev-Matching: 웹 백엔드 개발자(상반기) - 로또의 최고 순위와 최저 순위
//00 01 ~ 00 15 = 14분
public class LottoHighLow {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int correctNum = 0;
        int zeroNum = 0;
        for (int lotto : lottos) {
            if(Arrays.stream(win_nums).filter(win_num->lotto==win_num).findAny().isPresent()){
                correctNum++;
            }
            if(lotto==0){
                zeroNum++;
            }
        }
        switch (correctNum){
            case 2:
                answer[0]=5;
                break;
            case 3:
                answer[0]=4;
                break;
            case 4:
                answer[0]=3;
                break;
            case 5:
                answer[0]=2;
                break;
            case 6:
                answer[0]=1;
                break;
            default:
                answer[0]=6;
                break;
        }
        if(zeroNum==6){
            return new int[] {1,6};
        }else{
            int value = (answer[0]-zeroNum > 0)?answer[0]-zeroNum:1;
            return new int[] {value,answer[0]};
        }
    }
}
