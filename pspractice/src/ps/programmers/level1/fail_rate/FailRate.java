package ps.programmers.level1.fail_rate;

import java.util.Arrays;

//2019 KAKAO BLIND RECRUITMENT - 실패율
//21:53~22:20 = 27분
public class FailRate {
    public static int[] solution(int N, int[] stages) {
        Obj[] answer = new Obj[N];
        for(int i=0;i<N;i++) {
            answer[i] = new Obj(i+1);
        }
        for (int stage : stages) {
            for(int i=1;i<stage+1;i++){
                if(i==stage){
                    if(stage!=N+1) {
                        answer[i-1].notCompletePlus();
                    }
                }else {
                    answer[i-1].allPlus();
                }
            }
        }
        for(int i=0;i<N;i++) {
            answer[i].setFailRate();
        }
        Arrays.sort(answer);
        return Arrays.stream(answer).mapToInt(Obj::getStage).toArray();
    }

    public static void main(String[] args) {
        solution(5,new int[] {2, 1, 2, 6, 2, 4, 3, 3});
    }

    static class Obj implements Comparable<Obj>{
        int stage;
        int allNumber;
        int complete;
        double failRate;

        public void setFailRate() {
            this.failRate = (double)(this.allNumber-this.complete) / this.allNumber;
        }

        public void allPlus(){
            allNumber++;
            complete++;
        }
        public void notCompletePlus(){
            allNumber++;
        }
        public int getStage() {
            return stage;
        }

        public Obj(int stage) {
            this.stage = stage;
            this.allNumber = 0;
            this.complete = 0;
            this.failRate = 0;
        }

        @Override
        public int compareTo(Obj o) {
            if(this.failRate<o.failRate){
                return 1;
            }
            else if(this.failRate>o.failRate){
                return -1;
            }
            else{
                return this.stage<o.stage ? -1: 1;
            }
        }
    }
}
