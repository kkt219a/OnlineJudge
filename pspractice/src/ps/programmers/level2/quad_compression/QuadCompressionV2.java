package ps.programmers.level2.quad_compression;

import java.util.Arrays;

//월간 코드 챌린지 시즌1 - 쿼드압축 후 개수 세기
// 2022/04/19 17:22 ~ 18:20, 20:04~20:22 = 72분 더 늘었넹
public class QuadCompressionV2 {
    int[] numbers = new int[2];
    int[][] arrays;
    public int[] solution(int[][] arr) {
        arrays = arr;
        int solve = solve(0,0, arrays.length-1, arrays.length-1, arrays.length/2);
        if(solve != -1) {
            numbers[solve]++;
        }
        return numbers;
    }

    // 0,6,1,7,1
    public int solve(int startX, int startY, int endX, int endY, int n) {
        System.out.println(startX + " "+startY + " "+endX + " "+endY);
        if(startX==endX && startY == endY) {
            return arrays[startX][startY];
        } else {
            // 0,6,0,6
            int topLeft = solve(startX, startY, startX+n-1, startY + n -1, n/2);// 0011
            // 0,6,1,7,1
            int topRight = solve(startX, startY+n, endX-n, endY, n/2); // 0437
            int bottomLeft = solve(startX+n, startY, endX, startY+n-1,n/2); // 0213
            int bottomRight = solve(startX+n, startY+n, endX, endY, n/2); // 2233
            if (topLeft == topRight && topLeft == bottomLeft && topLeft == bottomRight) {
                return topLeft;
            } else {
                if(topLeft != -1) {
                    numbers[topLeft]++;
                }
                if(topRight != -1) {
                    numbers[topRight]++;
                }
                if(bottomLeft != -1) {
                    numbers[bottomLeft]++;
                }
                if(bottomRight != -1) {
                    numbers[bottomRight]++;
                }
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        QuadCompressionV2 quadCompressionV2 = new QuadCompressionV2();
        int[] solution = quadCompressionV2.solution(
            new int[][] {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}});
        System.out.println(Arrays.toString(solution));
    }
}
