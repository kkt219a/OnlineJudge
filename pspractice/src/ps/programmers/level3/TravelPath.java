package ps.programmers.level3;

import java.util.*;

//깊이/너비 우선 탐색(DFS/BFS) - 여행경로
//23:25~24:58 : 다시 풀자 ㅠ
public class TravelPath {
    static Map<String, List<String>> airports = new HashMap<>();
    static int maxSize;
    static String answerTmp="";
    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        List<String> answers = new ArrayList<>();
        maxSize = tickets.length+1;
        for (String[] ticket : tickets) {
            List<String> arrivals = airports.getOrDefault(ticket[0], new ArrayList<>());
            arrivals.add(ticket[1]);
            List<String> arrivals2 = airports.getOrDefault(ticket[1], new ArrayList<>());
            airports.put(ticket[0],arrivals);
            airports.put(ticket[1],arrivals2);
        }
        dfs("ICN","ICN",1);
        for(int i=0;i<answerTmp.length();i+=3) {
            answers.add(answerTmp.substring(i,i+3));
        }
        return answers.toArray(answer);
    }
    public static void dfs(String departure, String candidateAns, int countryNum){
        if(countryNum==maxSize){
            answerTmp = answerTmp.isBlank() ? candidateAns : (answerTmp.compareTo(candidateAns)>0 ? candidateAns : answerTmp );
        }else{
            List<String> arrivals = airports.get(departure);
            for(int i=0;i< arrivals.size();i++){
                String arrival = arrivals.get(i);
                arrivals.remove(i);
                dfs(arrival, candidateAns+arrival, countryNum + 1);
                arrivals.add(i,arrival);
            }
        }
    }

}
