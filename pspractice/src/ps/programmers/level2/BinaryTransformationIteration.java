package ps.programmers.level2;

// 월간 코드 챌린지 시즌1 - 이진 변환 반복하기
// 2022/04/05 17:03~17:13 = 10분
public class BinaryTransformationIteration {
	public int[] solution(String s) {
		int lengthCount = 0;
		int count=0;
		while(!s.equals("1")) {
			count++;
			int startLength = s.length();
			s = s.replace("0","");
			int lastLength = s.length();
			lengthCount += startLength - lastLength;
			s = Integer.toString(lastLength,2);
		}
		return new int[]{count, lengthCount};
	}
}
