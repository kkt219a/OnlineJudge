package ps.programmers.level2.quad_compression;

import java.util.Arrays;

//월간 코드 챌린지 시즌1 - 쿼드압축 후 개수 세기
// 깔끔한 답
public class QuadCompressionV3 {
    int[] numbers = new int[2];
    int[][] arrays;
    public int[] solution(int[][] arr) {
        arrays = arr;
        divide(arr.length, 0,0);
        return numbers;
    }

    private void divide(int n, int y, int x) {
        if(n==1) {
            numbers[arrays[y][x]]++;
        } else {
            if(check(n, y, x)) {
                return;
            }
            divide(n / 2, y, x);
            divide(n / 2, y, x + n / 2);
            divide(n / 2, y + n / 2, x);
            divide(n / 2, y + n / 2, x + n / 2);
        }
    }

    private boolean check(int n, int y, int x) {
        for(int i=y;i<y+n;i++) {
            for(int j=x;j<x+n;j++) {
                if(arrays[i][j] != arrays[y][x]) {
                    return false;
                }
            }
        }
        numbers[arrays[y][x]]++;
        return true;
    }

}
