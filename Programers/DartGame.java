import java.util.ArrayList;

/**
 *
 * [2018 kakao blind recruitment] 다트게임 - 23분
 */
public class DartGame {

    public int solution(String dartResult) {
        int answer = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        int cur = 0;

        for(int i=0;i<dartResult.length();i++){

            int tmpNum = 0;
            if(dartResult.charAt(i+1)=='0'){
                i++;
                tmpNum = 10;
            }else{
               tmpNum = dartResult.charAt(i)-48;
            }

            i++;
            if(dartResult.charAt(i)=='D'){
                tmpNum = tmpNum*tmpNum;
            }else if(dartResult.charAt(i)=='T'){
                tmpNum = tmpNum*tmpNum*tmpNum;
            }

            i++;
            if(i==dartResult.length()) {
                ans.add(tmpNum);
                break;
            }
            if(dartResult.charAt(i)<48||dartResult.charAt(i)>57){
                if(dartResult.charAt(i)=='*'){
                    if(ans.size()!=0){
                        ans.set(ans.size()-1,ans.get(ans.size()-1)*2);
                    }
                    tmpNum *= 2;
                }else{
                    tmpNum *= (-1);
                }
                i++;
            }
            ans.add(tmpNum);

            i--;
        }

        for (Integer an : ans) {
            answer +=an;
        }

        return answer;
    }

}

/**
 총 3번의 기회, 각 기회마다 0~10점, S,D,T는 1제곱, 2제곱, 3제곱이다. 점수마다 하나씩 존재
 옵션으로 스타상(*) 해당 점수와 바로 전에 얻은 점수를 각 2배로 만듬, 첫번째도 나올 수 있고, 해당 점수만!
 스타상 효과는 다른 스타상과 중첩 가능, 중첩된 스타상은 4배, 아차상과도 중첩 가능. 아차+스타 = -2배
 아차상(#) 해당점수 마이너스
 스타상과 아차상은 점수마다 둘 중 하나만 존재할 수 있고 존재하지 않을수도.

 점수|보너스|[옵션]

 */