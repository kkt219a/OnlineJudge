import java.util.*;

/**
 *
 * [2019 kakao blind recruitment] 실패율 - 85분
 */

public class FailRate {

    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        HashMap<Integer, Pair> map = new HashMap<Integer,Pair>();
        for(int i=1;i<=N+1;i++){
            map.put(i,new Pair(0,0));
        }
        for (int stage : stages) {
            for(int i=1;i<=stage;i++){
                Pair pair = map.get(i);
                pair.allNum++;
                map.replace(i,pair);
                if(i==stage){
                    Pair pair2 = map.get(i);
                    pair2.curNum++;
                    map.replace(i,pair2);
                }
            }
        }
        Map<Integer,Double> map2 = new HashMap<Integer,Double>();
        for(int i=1;i<=N;i++){
            Pair pair = map.get(i);
            double val = 0;
            if(pair.curNum!=0&&pair.allNum!=0){
                val = (double)pair.curNum/(double)pair.allNum;
            }
            map2.put(i,val);
        }
        List<Integer> keySetList = new ArrayList<>(map2.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map2.get(o2).compareTo(map2.get(o1))));

        int i=0;
        answer = new int[N];
        for (Integer integer : keySetList) {
            answer[i++]=integer;
        }

        return answer;
    }


    static class Pair{
        int curNum;
        int allNum;
        public Pair(int cur, int all) {
            this.allNum=all;
            this.curNum=cur;
        }
    }


}

/**

 스테이지 도달은 했으나 아직 ㅋㄹ리어 못한 플에이어 수 / 스테이지에 도달한 플레이어 수
 전체 스테이지 개수 N, 게임 이용하는 사용자가 현재 멈춰있는 스테이지의 번호 배열 stages
 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return

 이용자가 m단계에 멈춰있으면 1~m까지 a 값을 1증가, m에는 b값을 1 증가

 1 3 2 1 0 1
 8 7
 */