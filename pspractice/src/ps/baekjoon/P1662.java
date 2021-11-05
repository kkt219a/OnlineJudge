package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

//14:43~15:43
public class P1662 {
    static String sentence;
    static Stack<String> s = new Stack<>();
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        sentence = br.readLine();
        int len = sentence.length();
        for(int i=0;i<len;i++){
            String c= String.valueOf(sentence.charAt(i));
            if(!c.equals(")")){
                s.push(c);
            }else{
                int tempSum = 0;
                while(!s.isEmpty()&& !s.peek().equals("(")){
                    String v = s.pop();
                    tempSum += v.startsWith("*") ? Integer.parseInt(v.substring(1)) : v.length();
                }
                s.pop();
                s.push("*"+(tempSum*Integer.parseInt(s.pop())));
            }
        }
        while(!s.isEmpty()){
            String v = s.pop();
            sum += v.startsWith("*") ? Integer.parseInt(v.substring(1)) : v.length();
        }
        System.out.println(sum);
    }
}
