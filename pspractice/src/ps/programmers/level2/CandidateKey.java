package ps.programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

// 2019 KAKAO BLIND RECRUITMENT - 후보키
// 1차 - 못풀었었음 90분 이상
// 2차 - 2022/04/01 00:43~ 01:55 = 62분 실패
// 3차 - 2022/04/14 20:51~21:29 = 38분, 다시!!!
public class CandidateKey {
    String[][] relations;
    List<List<Integer>> ans = new ArrayList<>();

    public int solution(String[][] relation) {
        relations = relation;
        dfs(-1,new HashMap<>(),"");
        return ans.size();
    }

    public void dfs(int point, Map<Integer,String> elementMap, String seq) {
        HashSet<String> values = new HashSet<>(elementMap.values());
        if(values.size() == elementMap.size()&&values.size()!=0) {
            boolean ins = true;
            List<Integer> arrays = Arrays.stream(seq.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
            List<List<Integer>> deleteValues = new ArrayList<>();
            for (List<Integer> an : ans) {
                if(an.containsAll(arrays)) {
                    deleteValues.add(an);
                } else if(arrays.containsAll(an)) {
                    ins = false;
                }
            }
            if(ins) {
                for (List<Integer> value : deleteValues) {
                    ans.remove(value);
                }
                Collections.sort(arrays);
                ans.add(arrays);
            }
        } else {
            for (int i = point + 1; i < relations[0].length; i++) {
                HashMap<Integer, String> newMap = new HashMap<>(elementMap);
                for (int j = 0; j < relations.length; j++) {
                    newMap.put(j, elementMap.getOrDefault(j, "") + relations[j][i]);
                }
                dfs(i, newMap, seq + i);
            }
        }
    }

    public static void main(String[] args) {
        CandidateKey candidateKey = new CandidateKey();
        int a = candidateKey.solution(
            new String[][] {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}});
        System.out.println(a);
    }

}
