package ps.programmers.level2.phone_list;

import java.util.HashSet;
import java.util.Set;

//해시 - 전화번호 목록
// 틀린 솔루션
public class PhoneList {
    Set<String> list = new HashSet<>();
    public boolean solution(String[] phone_book) {
        for (String s : phone_book) {
            for (String s1 : list) {
                boolean b = s.length() < s1.length() ? s1.startsWith(s) : s.startsWith(s1);
                if(b){
                    return false;
                }
            }
            list.add(s);
        }
        return true;
    }
}
