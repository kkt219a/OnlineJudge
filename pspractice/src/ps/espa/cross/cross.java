//package ps.espa.cross;

import java.io.*;
import java.util.*;

public class cross {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("./cross.inp"));
        PrintWriter pw = new PrintWriter("./cross.out");
        for(int i=0, t=Integer.parseInt(br.readLine()); i < t ; i++){
            int num = Integer.parseInt(br.readLine());
            int answer = 0;
            int[] s1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] s2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<num;j++){
                for(int k=0;k<num;k++){
                    if(s2[k]==s1[j]){
                        s1[j] = k;
                        break;
                    }
                }
            }
            for(int j=0;j<num;j++){
                int s2Idx = s1[j];
                for(int k=0;k<j;k++){
                    if(s2Idx<s1[k]){
                        answer++;
                    }
                }
            }
            pw.println("Case "+(i+1)+": "+answer);
        }
        br.close();
        pw.close();
    }
}
