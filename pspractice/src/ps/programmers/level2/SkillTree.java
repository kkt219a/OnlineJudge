package ps.programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

// Summer/Winter Coding(~2018) - 스킬트리
// 2022/03/15 14:21 ~ 14:37 = 16분
public class SkillTree {
	public int solution(String skill, String[] skill_trees) {
		List<String> skills = Arrays.stream(skill.split("")).collect(Collectors.toList());
		int nowIdx, cnt = 0, i;
		for (String skill_tree : skill_trees) {
			nowIdx = 0;
			for(i=0;i<skill_tree.length();i++) {
				String nowSkill = String.valueOf(skill_tree.charAt(i));
				int idx = skills.indexOf(nowSkill);
				if(idx==-1) {
					continue;
				} else if(idx>nowIdx) {
					break;
				}
				nowIdx++;
			}
			if(i== skill_tree.length()) {
				System.out.println(skill_tree);
				cnt++;
			}
		}
		return cnt;
	}
}
