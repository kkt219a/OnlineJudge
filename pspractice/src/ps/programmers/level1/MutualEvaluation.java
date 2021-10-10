package ps.programmers.level1;

// 23:02~23:22
class MutualEvaluation {
    public String solution(int[][] scores) {
        String answer = "";
        int max, min, sum;
        for(int i=0;i<scores.length;i++){
            min = max = scores[i][i];
            sum = 0;
            boolean equal = false;
            for(int j=0;j<scores[i].length;j++){
                if(i==j) continue;
                min = Math.min(min,scores[j][i]);
                max = Math.max(max,scores[j][i]);
                sum += scores[j][i];
                if(scores[j][i] == scores[i][i]) equal = true;
            }
            if((min!=scores[i][i]&&max!=scores[i][i])||equal){
                answer += getScore(((double)sum+scores[i][i]) / scores[i].length);
            }else{
                answer += getScore(((double)sum) / (scores[i].length -1));
            }
        }
        return answer;
    }

    public String getScore(double num){
        System.out.println(num);
        if(num>=90) return "A";
        else if(num>=80) return "B";
        else if(num>=70) return "C";
        else if(num>=50) return "D";
        else return "F";
    }
}