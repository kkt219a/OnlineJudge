package ps.programmers.level1;

//2018 KAKAO BLIND RECRUITMENT - [1차] 다트 게임
//23:38~23:54 = 16분
public class DartGame {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];
        int length = dartResult.length();
        int cur = 0;
        for(int i=0;i<length;i++){
            String tmpScore = ""+dartResult.charAt(i);
            if(dartResult.charAt(i+1)==48){
                tmpScore+="0";
                i++;
            }
            i++;
            score[cur] = Integer.parseInt(tmpScore);
            if(dartResult.charAt(i)=='D'){
                score[cur] *= score[cur];
            }else if(dartResult.charAt(i)=='T'){
                score[cur] *= score[cur]*score[cur];
            }
            if(i+1>=length){
                break;
            }else if(dartResult.charAt(i+1)>47&&dartResult.charAt(i+1)<58){
                cur++;
            }else{
                i++;
                if(dartResult.charAt(i)=='*'){
                    score[cur]*=2;
                    if(cur!=0){
                        score[cur-1]*=2;
                    }
                }else{
                    score[cur]*=-1;
                }
                cur++;
            }
        }
        answer = score[0] + score[1] + score[2];
        return answer;
    }

}
