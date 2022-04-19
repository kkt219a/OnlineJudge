package ps.programmers.level2.quad_compression;

//월간 코드 챌린지 시즌1 - 쿼드압축 후 개수 세기
//14:45~ 15:35: 50분
public class QuadCompression {
    static int num;
    static int[][] arrays;
    static int[] ans = {0,0};
    public static int[] solution(int[][] arr) {
        arrays = arr;
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
}
