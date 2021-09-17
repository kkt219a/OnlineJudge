package ps.programmers.dontknow;

import java.util.*;

public class Four {
    static int[] apeachInfo;
    // 총점수가 키값, 배열이 개당 점수
    static HashMap<Integer, ArrayList<Integer>> lianScore = new HashMap<>();
    static int number;
    public static int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        apeachInfo = info.clone();
        number = n;
        dfs(0,n,"");
        ArrayList<Integer> integers = new ArrayList<>(lianScore.keySet());
        integers.sort(Collections.reverseOrder());
//        for (Integer integer : integers) {
//            System.out.println("integer = " + integer);
//        }
//        for (ArrayList<Integer> value : lianScore.values()) {
//            System.out.println(value+" ");
//        }
        if(integers.get(0)>0){
            ArrayList<Integer> integers1 = lianScore.get(integers.get(0));
            for(int i=0;i<11;i++){
                answer[i] = integers1.get(i);
            }
            return answer;
        }else{
            return new int[]{-1};
        }
    }

    public static void dfs(int idx, int remainArrow, String dashScore){
        if(idx==11){
//            System.out.println("dashScore = " + dashScore);
            if(remainArrow!=0){

            }else {
                String[] s = dashScore.split(" ");
                int lianMaxScore = 0;
                int appeachMaxScore = 0;
                ArrayList<Integer> scores = new ArrayList<>();
                for (int i = 1; i < s.length; i++) {
                    int lianNum = Integer.parseInt(s[i]);
                    int appeachNum = apeachInfo[i - 1];
                    scores.add(lianNum);
                    if (lianNum == 0 && appeachNum == 0) {
                    } else {
                        lianNum = lianNum <= appeachNum ? 0 : 10 - i + 1;
                        appeachNum = lianNum <= appeachNum ? 10 - i + 1 : 0;
                    }
                    lianMaxScore += lianNum;
                    appeachMaxScore += appeachNum;
                }
                if (lianScore.containsKey(lianMaxScore - appeachMaxScore)) {
                    ArrayList<Integer> integers = lianScore.get(lianMaxScore - appeachMaxScore);
                    boolean change = false;
                    for (int i = 10; i >= 0; i--) {
                        if (integers.get(i) < scores.get(i)) {
                            change = true;
                            break;
                        }else if(integers.get(i)>scores.get(i)){
                            break;
                        }
                    }
//                    System.out.println("integers = " + integers);
//                    System.out.println("scores = " + scores);
//                    System.out.println("change = " + change);
//                    System.out.println();
                    if (change) {
                        lianScore.remove(lianMaxScore - appeachMaxScore);
                        lianScore.put(lianMaxScore - appeachMaxScore, scores);
                    }
                } else {
                    lianScore.put(lianMaxScore - appeachMaxScore, scores);
                }
            }
        }else{
            dfs(idx+1,remainArrow,dashScore+" 0");
            dfs(idx+1,remainArrow-apeachInfo[idx]-1, dashScore + " " + (apeachInfo[idx] + 1));
            if(remainArrow>0) {
                dfs(idx + 1, 0, dashScore + " " + remainArrow);
            }
//            if(remainArrow-apeachInfo[idx]-1>=0){
//                dfs(idx+1,remainArrow-apeachInfo[idx]-1, dashScore + " " + (apeachInfo[idx] + 1));
//            }else if(apeachInfo[idx]==0&&remainArrow>0){
//                dfs(idx+1,remainArrow-apeachInfo[idx]-1, dashScore + " " + (apeachInfo[idx] + 1));
//            }
        }
    }

    public static void main(String[] args) {
        int[] solution = solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3});
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
