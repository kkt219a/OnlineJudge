package ps.programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

// 2019 KAKAO BLIND RECRUITMENT - 후보키
// 1차 - 못풀었었음 90분 이상
// 2차 - 2022/04/01 00:43~ 01:55 = 62분 실패
public class CandidateKey {
    // (1) relation의 column 길이만큼 StringBuilder
    // (2) dfs
    int column, row, answer=0;
    String[][] relations;
    Set<Set<String>> seq = new HashSet<>();
    public int solution(String[][] relation) {
        column = relation.length;
        row = relation[0].length;
        relations = new String[column][row];
        for(int i=0;i<column;i++) {
            for(int j=0;j<row;j++) {
                relations[i][j] = relation[i][j];
            }
        }
        String[] sbs = new String[column];
        Arrays.fill(sbs, "");
        dfs(sbs,0,"");
        return seq.size();
    }

    public void dfs(String[] sbs, int idx, String sequence) {
        long distinctCount = Arrays.stream(sbs).distinct().count();
        long count = sbs.length;
        if(distinctCount == count) {
            Set<String> collect = Arrays.stream(sequence.split("")).collect(Collectors.toSet());
            seq = seq.stream()
                .filter(s -> s.containsAll(collect) || collect.containsAll(s))
                .collect(Collectors.toSet());
            boolean duplicate = seq.removeIf(s -> s.size() > collect.size());
            if(duplicate) {
                seq.add(collect);
            }
        } else {
            for (int i = idx; i < row; i++) {
                String[] sbts = Arrays.copyOf(sbs, sbs.length);
                for(int j=0;j<column;j++) {
                    sbts[j] += relations[j][i];
                }
                dfs(sbts, i+1, sequence+i);
            }
        }
    }//3,11,12,13,14,16,17,18,19,20,22,24~28

    public static void main(String[] args) {
        // CandidateKey candidateKey = new CandidateKey();
        // candidateKey.solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}});
        // System.out.println(candidateKey.answer);
    }

}
