package ps.programmers.level2.open_chatting;

import java.util.Arrays;
import java.util.HashMap;

//2019 KAKAO BLIND RECRUITMENT - 오픈채팅방
// 00 51 ~ 01:30 = 41분
public class OpenChatting {
    public static String[] solution(String[] record) {
        Long count = Arrays.stream(record).filter(reco -> !reco.contains("Change")).count();
        String[] answer = new String[count.intValue()];
        String enter = "님이 들어왔습니다.";
        String leave = "님이 나갔습니다.";
        HashMap<String, String> account = new HashMap<>();
        int i=0;
        for (String s : record) {
            String[] resultSplit = s.split(" ");
            if(resultSplit[0].equals("Enter")){
                if(account.get(resultSplit[1])!=null){
                    account.replace(resultSplit[1], resultSplit[2]);
                }
                account.put(resultSplit[1],resultSplit[2]);
                answer[i++] = resultSplit[1] + enter;
            }
            if(resultSplit[0].equals("Leave")){
                answer[i++] = resultSplit[1] + leave;
            }
            if(resultSplit[0].equals("Change")){
                account.replace(resultSplit[1], resultSplit[2]);
            }
        }
        for(int j=0;j<i;j++){
            String[] id = answer[j].split("님");
            answer[j] = answer[j].replace(id[0],account.get(id[0]));
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});
    }
}
