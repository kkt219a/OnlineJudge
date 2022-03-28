package ps.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 월간 코드 챌린지 시즌1 - 삼각 달팽이
// 2022/03/28 16:05~15:47 = 42분 - 빡구현은 다시!
public class TriangularSnail {
	int[][] tempAnswer;
	public int[] solution(int n) {
		tempAnswer = new int[n][n];
		calculate(0,0,n,1);
		List<Integer> answers = new ArrayList<>();
		for (int[] ints : tempAnswer) {
			for (int anInt : ints) {
				if(anInt==0) {
					break;
				}
				answers.add(anInt);
			}
		}
		return answers.stream().mapToInt(Integer::intValue).toArray();
	}

	public void calculate(int startX, int startY, int changeN, int startN) {
		if(changeN >=0 && startX>=0 && startY>=0 && tempAnswer[startX][startY] == 0) {
			for(int i=0;i<changeN;i++) {
				tempAnswer[startX+i][startY] = startN++;
			}
			startX += (changeN-1);
			for(int i=1;i<changeN;i++) {
				tempAnswer[startX][startY+i] = startN++;
			}
			startY += (changeN-1);
			for(int i=1;i<changeN-1;i++) {
				tempAnswer[startX-i][startY-i] = startN++;
			}
			calculate(startX-changeN+3, startY-changeN+2,changeN-3 ,startN);
		}
	}

	public static void main(String[] args) {
		TriangularSnail triangularSnail = new TriangularSnail();
		System.out.println(Arrays.toString(triangularSnail.solution(4)));
	}
}
