package ps.programmers.level2.open_chatting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//2019 KAKAO BLIND RECRUITMENT - 오픈채팅방
// 2022/04/18 19:15~19:40 = 25분
public class OpenChattingV2 {
    List<User> userInfos = new ArrayList<>();
    Map<String, String> ids = new HashMap<>();
    public String[] solution(String[] record) {
        for (String rec : record) {
            String[] infos = rec.split(" ");
            String info = infos[0];
            if(!info.equals("Change")) {
                userInfos.add(new User(infos[1],info));
            } if(!info.equals("Leave")) {
                ids.put(infos[1], infos[2]);
            }
        }
        return userInfos.stream().map(u -> ids.get(u.id) + u.message).toArray(String[]::new);
    }

    class User {
        String id;
        String message;
        public User(String id, String message) {
            this.id = id;
            this.message = message.equals("Enter") ? "님이 들어왔습니다." : "님이 나갔습니다.";
        }
    }
}
