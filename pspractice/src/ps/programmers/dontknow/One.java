package ps.programmers.dontknow;

import java.util.HashMap;
import java.util.HashSet;

public class One {
    //아이디, 날 신고한 아이디
    static HashMap<String, HashSet<String>> a = new HashMap<>();
    //아이디, 메일받을 횟수
    static HashMap<String, Integer> b = new HashMap<>();

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        for (String s : id_list) {
            a.put(s,new HashSet<>());
            b.put(s,0);
        }
        for (String s : report) {
            String[] split = s.split(" ");
            HashSet<String> strings = a.get(split[1]);
            strings.add(split[0]);
        }
        for (String s : a.keySet()) {
            HashSet<String> strings = a.get(s);
            if(strings.size()>=k){
                for (String string : strings) {
                    b.put(string,b.get(string)+1);
                }
            }
        }
        for(int i=0;i< id_list.length; i++){
            answer[i]= b.get(id_list[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(new String[]{"muzi", "frodo", "apeach", "neo"},new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},2);
    }
}
