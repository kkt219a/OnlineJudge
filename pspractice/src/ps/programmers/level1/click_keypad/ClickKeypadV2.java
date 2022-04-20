package ps.programmers.level1.click_keypad;

import java.awt.*;

//키패드 누르기 - 2020 카카오 인턴십
// 2022/04/20 11:26~11:56 = 26분
public class ClickKeypadV2 {
	public String solution(int[] numbers, String hand) {
		hand = hand.equals("left") ? "L" : "R";
		StringBuilder sb = new StringBuilder();
		Point leftPad = new Point(3,0), rightPad = new Point(3,2);
		Point[] keypad = new Point[10];
		keypad[0] = new Point(3,1);
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				keypad[i*3 +j+1] = new Point(i,j);
			}
		}
		for (int number : numbers) {
			if (number % 3 == 1) {
				sb.append("L");
				leftPad.setLocation(keypad[number]);
			} else if (number % 3 == 0) {
				sb.append("R");
				rightPad.setLocation(keypad[number]);
			} else {
				double leftDist = Math.abs(leftPad.x - keypad[number].x) + Math.abs(leftPad.y - keypad[number].y);
				double rightDist = Math.abs(rightPad.x - keypad[number].x) + Math.abs(rightPad.y - keypad[number].y);
				if(leftDist == rightDist) {
					sb.append(hand);
					if(hand.equals("L")) {
						leftPad.setLocation(keypad[number]);
					} else {
						rightPad.setLocation(keypad[number]);
					}
				} else {
					if(leftDist < rightDist) {
						sb.append("L");
						leftPad.setLocation(keypad[number]);
					} else {
						sb.append("R");
						rightPad.setLocation(keypad[number]);
					}
				}
			}
		}
		return sb.toString();
	}
}
