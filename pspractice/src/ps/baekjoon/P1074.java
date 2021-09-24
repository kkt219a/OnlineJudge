package ps.baekjoon;

import java.io.*;

//18:05~19:28  = 83분
public class P1074 {
    static int r,c,n, num,answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
        String[] total = ((String)br.readLine()).split(" ");
        n = Integer.parseInt(total[0]);r = Integer.parseInt(total[1]);c = Integer.parseInt(total[2]);
        divide(0,0, n);
        bw.write(num);
    }

    public static void divide(int valueStart, int valueEnd, int k){
        if(k==0){
            num = answer;
        }else{
            int val = (int) Math.pow(2, k)-1;
            int val2 = val/2;
            //좌상행
            if(valueEnd<=c&&valueStart<=r&&c<=valueEnd+val2&&r<=valueStart+val2){
                divide(valueStart,valueEnd,k-1);
            }
            //우상행
            else if(valueEnd+val2+1<=c&&valueStart<=r&&c<=valueEnd+val&&r<=valueStart+val2){
                answer+= Math.pow(2,2*k-2);
                divide(valueStart,valueEnd+val2+1,k-1);
            }
            //좌하행
            else if(valueEnd<=c&&valueStart+val2+1<=r&&c<=valueEnd+val2&&r<=valueStart+val){
                answer+= Math.pow(2,2*k-2)*2;
                divide(valueStart+val2+1,valueEnd,k-1);
            }
            //우하행
            else if(valueEnd+val2+1<=c&&valueStart+val2+1<=r&&c<=valueEnd+val&&r<=valueStart+val){
                answer+= Math.pow(2,2*k-2)*3;
                divide(valueStart+val2+1,valueEnd+val2+1,k-1);
            }
        }
    }
}
