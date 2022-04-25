package ps.programmers.level3.bad_user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// 2019 카카오 개발자 겨울 인턴십 - 불량 사용자
// 2022/04/26 02:12 ~ 02:38 = 26분
public class BadUser {
	String[] banIds;
	String[] userIds;
	boolean[] userIdVisited;
	Set<String> realBanIds = new HashSet<>();
	public int solution(String[] user_id, String[] banned_id) {
		userIds = user_id;
		banIds = banned_id;
		userIdVisited = new boolean[user_id.length];
		dfs(0, "");
		return realBanIds.size();
	}

	private void dfs(int idx, String users) {
		if(banIds.length == idx) {
			String[] compString = users.split(" ");
			Arrays.sort(compString);
			String collect = String.join(" ", compString);
			realBanIds.add(collect);
		} else {
			// 유저아이디 전체 조회
			for(int i=0;i<userIds.length;i++) {
				// 해당 유저 방문 안했고 매치가 되면 추가해서 다음 dfs로. 물론 방문 처리도 하고
				if(!userIdVisited[i] && match(userIds[i],banIds[idx])) {
					userIdVisited[i] = true;
					dfs(idx+1,users+userIds[i]+" ");
					userIdVisited[i] = false;
				}
			}
		}
	}

	// 매치되면 true 반환
	private boolean match(String userId, String banId) {
		if(userId.length() != banId.length()) {
			return false;
		}
		for(int i=0;i<userId.length();i++) {
			if(banId.charAt(i)!='*' && userId.charAt(i) != banId.charAt(i)) {
				return false;
			}
		}
		return true;
	}
}
