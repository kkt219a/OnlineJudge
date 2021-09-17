package ps.programmers.level2;

import java.util.Stack;

// 2020 KAKAO BLIND RECRUITMENT - 괄호 변환
// 20:09~ 21:34 = 1:25분
public class TranslatedParentheses {
    public String solution(String p) {
        return splitUv(p);
    }

    //1단계 함수
    private String splitUv(String w){
        int openNum = 0;
        int closeNum = 0;
        boolean uStatus = true;
        StringBuilder u = new StringBuilder();
        Stack<String> correct = new Stack<>();
        StringBuilder v = new StringBuilder();
        if(w.isEmpty()){
            return w;
        }
        String[] splitW = w.split("");
        for (String s : splitW) {
            if(closeNum != 0 && openNum == closeNum){
                closeNum = 0;
                uStatus = false;
            }
            if(uStatus){
                if(s.equals("("))
                    openNum++;
                else
                    closeNum++;
                if(!correct.isEmpty()){
                    String peek = correct.peek();
                    if(peek.equals("(")&&s.equals(")")){
                        correct.pop();
                    }else{
                        correct.push(s);
                    }
                }else {
                    correct.push(s);
                }
                u.append(s);
            }else{
                v.append(s);
            }
        }
        if(correct.isEmpty()){
            return u + splitUv(v.toString());
        }else{
            StringBuilder newU = new StringBuilder();
            if(u.length()>1) {
                u.deleteCharAt(0);
                u.deleteCharAt(u.length() - 1);
                for(int i=0;i<u.length();i++){
                    newU.append((u.charAt(i)=='('?")":"("));
                }
            }
            return "(" + splitUv(v.toString()) + ")" + newU;
        }
    }

}
