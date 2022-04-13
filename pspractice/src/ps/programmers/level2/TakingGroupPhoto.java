package ps.programmers.level2;

// 2017 카카오코드 본선 - 단체사진 찍기(1449ms)
// 2022/04/13 15:01~15:29 = 28분
public class TakingGroupPhoto {
	char[] persons = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	boolean[] visited = new boolean[8];
	String[] datas;
	int ans = 0;
	public int solution(int n, String[] data) {
		datas = data;
		dfs("");
		return ans;
	}

	public void dfs(String s) {
		if (s.length() == 8) {
			if(valid(s)) {
				ans++;
			}
		} else {
			for (int i = 0; i < 8; i++) {
				if (!visited[i]) {
					visited[i] = true;
					dfs(s+persons[i]);
					visited[i] = false;
				}
			}
		}
	}

	private boolean valid(String column) {
		for (String data : datas) {
			char eq = data.charAt(3);
			int dist = Character.getNumericValue(data.charAt(4));
			int realDist = Math.abs(column.indexOf(data.charAt(0)) - column.indexOf(data.charAt(2)))-1;
			if(!((eq=='>' && realDist > dist) || (eq=='<' && realDist < dist) || (eq=='=' && dist == realDist))) {
				return false;
			}
		}
		return true;
	}
}
