package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1780 {
    static int num;
    static int[][] arrays;
    static int[] ans = {0,0,0};
    public static int[] solution() {
        int length = arrays.length;
        while(length!=1){
            num++;
            length/=3;
        }
        int divide = divide(0, 0, num);
        if(divide!=3){
            ans[divide]++;
        }
        return ans;
    }

    public static int divide(int x, int y, int n){
        if(n==0){
            return arrays[x][y];
        }
        else{
            int v = (int)Math.pow(3,n)-1;
            int leftTop = divide(x, y, n - 1); // 0 0
            int midTop = divide(x+(v/3+1), y, n - 1); // 0 0
            int rightTop = divide(x +(v/3+1)*2, y, n - 1); // 1, 0
            int leftMid = divide(x, y+v/3+1, n - 1); // 0 0
            int midMid = divide(x+v/3+1, y+v/3+1, n - 1); // 0 0
            int rightMid = divide(x +(v/3+1)*2, y+v/3+1, n - 1); // 1, 0
            int leftBottom = divide(x, y +(v/3+1)*2, n - 1); // 0, 1
            int midBottom = divide(x+v/3+1,y+(v/3+1)*2,n-1);
            int rightBottom = divide(x +(v/3+1)*2, y +(v/3+1)*2, n - 1); // 1, 1
            if(leftTop!=3){ ans[leftTop]++; }
            if(midTop!=3){ ans[midTop]++; }
            if(rightTop!=3){ ans[rightTop]++; }
            if(leftMid!=3){ ans[leftMid]++; }
            if(midMid!=3){ ans[midMid]++; }
            if(rightMid!=3){ ans[rightMid]++; }
            if(leftBottom!=3){ ans[leftBottom]++; }
            if(midBottom!=3){ ans[midBottom]++; }
            if(rightBottom!=3){ ans[rightBottom]++; }
            if(leftTop==0&&midTop==0&&rightTop==0&&leftMid==0&&midMid==0&&rightMid==0&&leftBottom==0&&midBottom==0&&rightBottom==0){
                ans[leftTop]-=9;
                return 0;
            }else if(leftTop==1&&midTop==1&&rightTop==1&&leftMid==1&&midMid==1&&rightMid==1&&leftBottom==1&&midBottom==1&&rightBottom==1){
                ans[leftTop] -= 9;
                return 1;
            }else if(leftTop==2&&midTop==2&&rightTop==2&&leftMid==2&&midMid==2&&rightMid==2&&leftBottom==2&&midBottom==2&&rightBottom==2){
                ans[leftTop] -= 9;
                return 2;
            }else{
                return 3;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arrays = new int[n][n];
        for(int i=0;i<n;i++){
            String[] s = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                int i1 = Integer.parseInt(s[j]);
                if(i1==-1) i1 = 2;
                arrays[i][j] = i1;
            }
        }
        int[] solution = solution();
        System.out.println(solution[2]);
        System.out.println(solution[0]);
        System.out.println(solution[1]);
    }
}
