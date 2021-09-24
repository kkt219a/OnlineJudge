package ps.baekjoon;

import java.io.*;

//22:50~23:48 = 58분
public class P1074V2 {
    static int r, c, n, answer, x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        String[] total = ((String)br.readLine()).split(" ");
        n = Integer.parseInt(total[0]);r = Integer.parseInt(total[1]);c = Integer.parseInt(total[2]);
        while(n!=0){
            int v = (int) Math.pow(2,n) -1;
            int v2 = (int) Math.pow(2,2*n-2);
            if(x+v/2+1<=c&&y<=r&&c<=x+v&&r<=y+v/2){
                answer+=v2;
                x += v/2+1;
            }else if(x<=c&&y+v/2+1<=r&&c<=x+v/2&&r<=y+v){
                answer+=2*v2;
                y+=v/2+1;
            }else if(x+v/2+1<=c&&y+v/2+1<=r&&c<=x+v&&r<=y+v){
                x += v/2+1;
                y += v/2+1;
                answer+=3*v2;
            }
            n--;
        }
        System.out.println(answer);
    }
}
