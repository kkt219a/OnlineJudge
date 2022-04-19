package ps.programmers.level2.translated_parentheses;

import java.util.Stack;

// 2020 KAKAO BLIND RECRUITMENT - 괄호 변환
// 2022/04/19 13:52~14:32 = 40분
public class TranslatedParenthesesV2 {
    public String solution(String p) {
        return recur(p);
    }

    private String recur(String sentence) {
        if(sentence.length() == 0) {
            return "";
        }
        Stack<Character> s = new Stack<>();
        int left=0, right=0, idx=0;
        for(;idx<sentence.length();idx++) {
            char m = sentence.charAt(idx);
            if(m=='(') {
                s.push(m);
                left++;
            } else {
                if(s.isEmpty()) {
                    s.push(m);
                    right++;
                } else {
                    Character m2 = s.peek();
                    if (m2 == '(') {
                        s.pop();
                        left--;
                    } else {
                        s.push(m);
                        right++;
                    }
                }
            }
            if(left==right || s.isEmpty()) {
                break;
            }
        }
        if(s.isEmpty()) {
            return sentence.substring(0,idx+1) + recur(sentence.substring(idx+1));
        } else {
            return "(" + recur(sentence.substring(idx+1))+ ")" + reverse(sentence.substring(1,idx));
        }
    }

    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            sb.append((s.charAt(i)=='(') ? ')' : '(');
        }
        return sb.toString();
    }
}
