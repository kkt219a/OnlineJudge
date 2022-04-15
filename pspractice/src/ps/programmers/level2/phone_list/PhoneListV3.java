package ps.programmers.level2.phone_list;

import java.util.Arrays;

//해시 - 전화번호 목록
// 2022/04/15 13:27~13:44 = 17분
public class PhoneListV3 {
	public boolean solution(String[] phone_book) {
		Arrays.sort(phone_book);
		for (int i = 0; i < phone_book.length; i++) {
			if (i + 1 != phone_book.length && phone_book[i + 1].startsWith(phone_book[i])) {
				return false;
			}
		}
		return true;
	}
}
