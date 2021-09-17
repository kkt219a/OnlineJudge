package ps.programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

//2021 KAKAO BLIND RECRUITMENT - 순위 검색
// 참조 - 이분탐색
public class RankingSearch {
    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    static ArrayList<Integer> scores;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for(int i=0;i<info.length;i++){
            dfs("",0,info[i].split(" "));
        }
        for (String s : map.keySet()) {
            ArrayList<Integer> integers = map.get(s);
            Collections.sort(integers);
        }
        for(int i=0; i< query.length;i++){
            String replaceVal = query[i].replace(" and ", "");
            String[] realVal = replaceVal.split(" ");
            answer[i] = find(realVal[0],Integer.parseInt(realVal[1]));
        }
        return answer;
    }

    public void dfs(String saved, int depth, String[] value){
        if(depth==4){
            if(map.containsKey(saved)){
                map.get(saved).add(Integer.parseInt(value[depth]));
            }else{
                scores = new ArrayList<>();
                scores.add(Integer.parseInt(value[depth]));
                map.put(saved,scores);
            }
        }else {
            dfs(saved + "-", depth + 1, value);
            dfs(saved + value[depth], depth + 1, value);
        }
    }

    public int find(String val, Integer score){
        if(!map.containsKey(val)){
            return 0;
        }else{
            ArrayList<Integer> integers = map.get(val);
            int low = 0, high = integers.size()-1;
            while(low<=high){
                int mid = (low+high)/2;
                if(score<=integers.get(mid)){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            return integers.size()-low;
        }
    }
}
