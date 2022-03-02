package ps.programmers.level1;

import java.util.*;

// 2022 KAKAO BLIND RECRUITMENT - 신고 결과 받기
// 2022/03/01 17:10~ 17:50 --> 다시
public class GetReportResult {
	public int[] solution(String[] id_list, String[] report, int k) {
		// 회원이 메일을 통보받을 횟수
		Map<String, Integer> reportMailNums = new LinkedHashMap<>();
		// 회원, 나를 신고한 회원
		Map<String, Set<String>> reportResults = new HashMap<>();
		for (String s : id_list) {
			reportResults.put(s,new HashSet<>());
			reportMailNums.put(s,0);
		}
		for (String s : report) {
			String[] reportInfo = s.split(" ");
			Set<String> reportSet = reportResults.get(reportInfo[1]);
			reportSet.add(reportInfo[0]);
			reportResults.put(reportInfo[1],reportSet);
		}
		for (Map.Entry<String, Set<String>> entry : reportResults.entrySet()) {
			Set<String> reportMembers = entry.getValue();
			if(reportMembers.size() >= k) {
				for (String reportMember : reportMembers) {
					reportMailNums.put(reportMember,reportMailNums.get(reportMember)+1);
				}
			}
		}
		return Arrays.stream(reportMailNums.values().toArray(new Integer[0]))
			.mapToInt(Integer::intValue).toArray();
	}
	public static void main(String[] args) {

	}
}
