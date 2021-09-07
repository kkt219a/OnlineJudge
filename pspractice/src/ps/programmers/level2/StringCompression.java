package ps.programmers.level2;

import java.util.ArrayList;
import java.util.List;

// 2020 KAKAO BLIND RECRUITMENT - 문자열 압축
// 00 22 ~ 00 46 : 24분
public class StringCompression {
    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for(int i=1;i<s.length()/2+1;i++){
            answer = Math.min(splitString(s,i),answer);
        }
        if(answer==Integer.MAX_VALUE){
            return 1;
        }
        return answer;
    }
    private static int splitString(String s, int splitNum){
        List<String> buckets = new ArrayList<>();
        String val = "";
        for(int i=0; i<s.length();i+=splitNum){
            if(i+splitNum<s.length()) {
                buckets.add(s.substring(i, i + splitNum));
            }else{
                buckets.add(s.substring(i));
            }
        }
        int stack=1;
        String prevVal="";
        for (String bucket : buckets) {
            if(prevVal.equals(bucket)){
                stack++;
            }else{
                val += ((stack!=1) ? (String.valueOf(stack)+prevVal) : prevVal);
                stack = 1;
            }
            prevVal = bucket;
        }
        val += ((stack!=1) ? (String.valueOf(stack)+prevVal) : prevVal);
        return val.length();
    }

    public static void main(String[] args) {
        solution("ababcdcdababcdcd");
    }

}
