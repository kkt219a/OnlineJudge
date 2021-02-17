import java.util.*;

/**
 *
 * [2019 kakao blind recruitment] 오픈채팅방 - 24분
 */

public class OpenChatting {

    public String[] solution(String[] record) {
        HashMap<String, String> idName = new HashMap<>();
        Queue<Pair> statusId = new LinkedList<>();
        List<String> ansTmp = new ArrayList<>();

        for (String s : record) {
            String[] tmp = s.split(" ");
            if(!tmp[0].equals("Leave")){
                idName.put(tmp[1],tmp[2]);
            }
            if(!tmp[0].equals("Change")) {
                statusId.add(new Pair(tmp[0], tmp[1]));
            }
        }
        while(!statusId.isEmpty()){
            Pair peek = statusId.peek();
            String status = peek.status;
            if(status.equals("Enter")){
                status = idName.get(peek.id) + "님이 들어왔습니다.";
            }else if(status.equals("Leave")){
                status = idName.get(peek.id) + "님이 나갔습니다.";
            }
            ansTmp.add(status);
            statusId.poll();
        }
        return ansTmp.toArray(new String[ansTmp.size()]);
    }

    static class Pair{
        String status;
        String id;

        public Pair(String status, String id) {
            this.status = status;
            this.id = id;
        }
    }
}
