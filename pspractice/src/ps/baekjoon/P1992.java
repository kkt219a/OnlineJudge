package ps.baekjoon;

import java.io.*;

//16:32~17:20 = 48분
public class P1992 {
    static String[][] arrays;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int  num = Integer.parseInt((String) br.readLine());
        arrays = new String[num][num];
        for(int i=0;i<num;i++){
            String[] total = ((String)br.readLine()).split("");
            for(int j=0;j<num;j++){
                arrays[j][i] = total[j];
            }
        }
        int length = 0;
        while(num!=1){
            length++;
            num/=2;
        }
        String divide = divide("", 0, 0, length);
        System.out.println(divide);
    }

    public static String divide(String ans, int x, int y, int n){
        if(n==0){
            return arrays[x][y];
        }else{
            int v = (int)Math.pow(2,n)-1;
            String leftTop = divide(ans, x, y, n - 1);
            String rightTop = divide(ans, x + v / 2 + 1, y, n - 1);
            String leftBottom = divide(ans, x, y + v / 2 + 1, n - 1);
            String rightBottom = divide(ans,x + v / 2 + 1, y + v / 2 + 1, n - 1);
            if(leftTop.equals("0")&&rightTop.equals("0")&&leftBottom.equals("0")&&rightBottom.equals("0")){
                return "0";
            }else if(leftTop.equals("1")&&rightTop.equals("1")&&leftBottom.equals("1")&&rightBottom.equals("1")){
                return "1";
            }else{
                return "("+leftTop+rightTop+leftBottom+rightBottom+")";
            }
        }
    }
}
