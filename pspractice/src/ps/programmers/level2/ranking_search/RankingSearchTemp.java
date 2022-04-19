package ps.programmers.level2.ranking_search;

import java.util.ArrayList;
import java.util.List;

//2021 KAKAO BLIND RECRUITMENT - 순위 검색
// 23:33~24:00 = 27분(정확성 40점)
public class RankingSearchTemp {
    public int[] solution(String[] info, String[] query) {
        Obj[] objs = new Obj[info.length];
        int[] answer = new int[query.length];
        for(int i=0;i<info.length;i++){
            String[] s = info[i].split(" ");
            objs[i] = new Obj(s[0],s[1],s[2],s[3],Integer.parseInt(s[4]));
        }
        int j = 0;
        for (String s : query) {
            String[] s0 = s.split(" and "); // s0[0]: 언어, s0[1]: 직군, s0[2]: 경력
            String[] s1 = s0[3].split(" "); //s1[0]: 음식, s1[1]: 코테점수
            int cnt = 0;
            for(int i=0;i<info.length;i++){
                if(objs[i].equal(s0[0],s0[1],s0[2],s1[0],Integer.parseInt(s1[1]))){
                    cnt++;
                }
            }
            answer[j++] = cnt;
        }
        return answer;
    }

    static class Obj{
        private String language;
        private String job;
        private String jobYear;
        private String soulFood;
        private Integer score;

        public Obj(String language, String job, String jobYear, String soulFood, Integer score) {
            this.language = language;
            this.job = job;
            this.jobYear = jobYear;
            this.soulFood = soulFood;
            this.score = score;
        }

        public boolean equal(String language, String job, String jobYear, String soulFood, Integer score){
            boolean returnBool = this.score >=score;
            if(!language.equals("-")){
                returnBool &= language.equals(this.language);
            }
            if(!soulFood.equals("-")){
                returnBool = returnBool && soulFood.equals(this.soulFood);
            }
            if(!jobYear.equals("-")){
                returnBool = returnBool && jobYear.equals(this.jobYear);
            }
            if(!job.equals("-")){
                returnBool = returnBool && job.equals(this.job);
            }
            return returnBool;
        }
    }
}
