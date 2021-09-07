package ps.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 2021 KAKAO BLIND RECRUITMENT - 신규 아이디 추천
// 01:04~01:51 = 47분
public class NewIdRecommend {

    public static String solution(String new_id) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        char[] newIdChar = new_id.toLowerCase().toCharArray();

        for (char c : newIdChar) {
            if((c>47&&c<58)||(c>96&&c<123)||c=='.'||c=='_'||c=='-') {
                sb.append(c);
            }
        }

        for(int i=0;i< sb.length();i++){
            if(i!= sb.length()-1) {
                if (sb.charAt(i) == sb.charAt(i+1) && sb.charAt(i) =='.'){
                    sb.deleteCharAt(i--);
                }
            }
        }

        if(sb.length()!=0) {
            if (sb.charAt(sb.length() - 1) == '.') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        if(sb.length()!=0) {
            if (sb.charAt(0) == '.') {
                sb.deleteCharAt(0);
            }
        }

        if(sb.length()==0){
            sb.append('a');
        }

        if(sb.length()>15){
            sb.delete(15,sb.length());
            if(sb.charAt(sb.length()-1)=='.'){
                sb.deleteCharAt(sb.length()-1);
            }
        }

        for(;sb.length()<3;) {
            sb.append(sb.charAt(sb.length()-1));
        }

        answer = sb.toString();
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcdefghijklmn.p"));
    }
}
