package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

//다시
public class P14719 {
    static int val, sum,i;
    static int[] map,max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        br.readLine();
        map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        max = new int[map.length];
        for(i=val=0;i<map.length;val=Math.max(map[i],val),max[i]=val,i++);
        for(i=map.length-1,val=0;i>=0;i--){
            val=Math.max(val,map[i]);
            sum+=Math.max(0,Math.min(val,max[i])-map[i]);
        }
        System.out.println(sum);
    }
}
