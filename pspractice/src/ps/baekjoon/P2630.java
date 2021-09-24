package ps.baekjoon;

import java.io.*;

//월간 코드 챌린지 시즌1 - 쿼드압축 후 개수 세기와 같은 문제
public class P2630 {
    static int num;
    static int[][] arrays;
    static int[] ans = {0,0};
    public static int[] solution() {
        int length = arrays.length;
        while(length!=1){
            num++;
            length/=2;
        }
        int divide = divide(0, 0, num);
        if(divide!=2){
            ans[divide]++;
        }
        return ans;
    }

    public static int divide(int x, int y, int n){
        if(n==0){
            return arrays[x][y];
        }
        else{
            int v = (int)Math.pow(2,n)-1; // 1
            int leftTop = divide(x, y, n - 1); // 0 0
            int rightTop = divide(x + v / 2 + 1, y, n - 1); // 1, 0
            int leftBottom = divide(x, y + v / 2 + 1, n - 1); // 0, 1
            int rightBottom = divide(x + v / 2 + 1, y + v / 2 + 1, n - 1); // 1, 1
            if(leftTop!=2){ ans[leftTop]++; }
            if(leftBottom!=2){ ans[leftBottom]++; }
            if(rightTop!=2){ ans[rightTop]++; }
            if(rightBottom!=2){ ans[rightBottom]++; }
            if(leftTop==0&&rightTop==0&&leftBottom==0&&rightBottom==0){
                ans[leftTop]-=4;
                return 0;
            }else if(leftTop==1&&rightTop==1&&leftBottom==1&&rightBottom==1){
                ans[leftTop] -= 4;
                return 1;
            }else{
                return 2;
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
                arrays[i][j] = Integer.parseInt(s[j]);
            }
        }
        int[] solution = solution();
        System.out.println(solution[0]);
        System.out.println(solution[1]);
    }
}
