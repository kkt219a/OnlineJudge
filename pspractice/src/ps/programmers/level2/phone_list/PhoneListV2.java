package ps.programmers.level2.phone_list;

import java.util.HashMap;
import java.util.Map;

//해시 - 전화번호 목록
// 찾아본 솔루션, 정답
public class PhoneListV2 {
    Map<String,Integer> list = new HashMap<>();
    public boolean solution(String[] phone_book) {
        for (String s : phone_book) {
            list.put(s,0);
        }
        for (String s : list.keySet()) {
            for(int i=0,j=s.length();i<j;i++){
                if(list.containsKey(s.substring(0,i))){
                    return false;
                }
            }
        }
        return true;
    }
}
