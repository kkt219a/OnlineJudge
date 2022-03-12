package ps.programmers.level1;

// 연습문제 - 핸드폰 번호 가리기
// 2022/03/13 01:04~01:06 = 2분
public class PhoneNumberHide {
	public String solution(String phone_number) {
		return "*".repeat(phone_number.length()-4) + phone_number.substring(phone_number.length()-4);
	}
}
