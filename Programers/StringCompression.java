import java.util.ArrayList;

/**
 *
 * [2021 kakao blind recruitment] 문자열 압축 - 37분
 */

public class StringCompression {

    public int solution(String s) {
        int answer = 987654321;
        int curCut = 1;
        int siz = s.length()/2;

        for(;curCut<=siz;curCut++){ // curCut 단위별로 자르기

            ArrayList<Pair> ls = new ArrayList<>();

            int i=0;
            for(;i<s.length()-curCut;i+=curCut){ // 단위별로
               String tmp = s.substring(i,i+curCut);
               if(ls.isEmpty()){
                   ls.add(new Pair(1,tmp));
               }else {
                   Pair last = ls.get(ls.size() - 1);
                   if (tmp.equals(last.voca)) { // 앞과 같은 단어면
                       last.num++; // 개수만 올리고
                       ls.remove(ls.size()-1);
                       ls.add(last);
                   }else{ //다른 단어면
                       ls.add(new Pair(1,tmp));
                   }
               }
            }

            String tmp = s.substring(i, s.length());
            if(ls.isEmpty()){
                ls.add(new Pair(1,tmp));
            }else {
                Pair last = ls.get(ls.size() - 1);
                if (tmp.equals(last.voca)) { // 앞과 같은 단어면
                    last.num++; // 개수만 올리고
                    ls.remove(ls.size()-1);
                    ls.add(last);
                }else{ //다른 단어면
                    ls.add(new Pair(1,tmp));
                }
            }

            int sum=0;
            for (Pair l : ls) {
                sum += (l.voca.length());
                if(!(String.valueOf(l.num)).equals("1"))
                    sum += (String.valueOf(l.num)).length();
            }
            answer = Math.min(sum,answer);
        }

        if(siz==0) answer=1;

        return answer;
    }

    static class Pair{
        int num;
        String voca;
        public Pair(int num, String voca) {
            this.num=num;
            this.voca=voca;
        }
    }

}
/**

 ababab라고 하자 어차피 n/2를 넘어가면 가장 짧은 길이는 될 수 없다.
 abababa
 */