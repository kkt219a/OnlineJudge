package ps.programmers.level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 2018 KAKAO BLIND RECRUITMENT - [3차] 파일명 정렬
// 2차 - 2022/04/02 17:52 ~ 18:47 - 오래걸림 다시!
public class FileNameSorting {
	static class CustomFile {
		String head;
		String number;
		String tail;
		Integer idx;

		public CustomFile(String head, String number, String tail, Integer idx) {
			this.head = head;
			this.number = number;
			this.tail = tail;
			this.idx = idx;
		}

		public String fullString() {
			return head+number+tail;
		}
	}

	public String[] solution(String[] files) {
		int idx = 0;
		List<CustomFile> customFiles = new ArrayList<>();
		for (String file : files) {
			int startNumberIdx = getStartNumberIdx(file);
			int numberEndIdx = getNumberEndIdx(file.substring(startNumberIdx),startNumberIdx);
			String head = file.substring(0, startNumberIdx);
			String number = file.substring(startNumberIdx,numberEndIdx);
			String tail = file.substring(numberEndIdx);
			customFiles.add(new CustomFile(head, number, tail, idx++));
		}
		customFiles.sort((o1, o2) -> {
			int headSorting = o1.head.compareToIgnoreCase(o2.head);
			if(headSorting != 0) {
				return headSorting;
			}
			int numberSorting = Integer.compare(Integer.parseInt(o1.number), Integer.parseInt(o2.number));
			if(numberSorting != 0) {
				return numberSorting;
			}
			return o1.idx.compareTo(o2.idx);
		});
		return customFiles.stream()
			.map(CustomFile::fullString)
			.toArray(String[]::new);
	}

	private int getNumberEndIdx(String afterHead, int startIdx) {
		for(int i=0;i<5 && afterHead.length() > i;i++) {
			if(!Character.isDigit(afterHead.charAt(i))) {
				return startIdx+i;
			}
		}
		return startIdx+(afterHead.length() < 6 ? afterHead.length() : 5);
	}

	private int getStartNumberIdx(String file) {
		for(int i=0;i<file.length();i++) {
			if(Character.isDigit(file.charAt(i))) {
				return i;
			}
		}
		return file.length()-1;
	}

	public static void main(String[] args) {
		FileNameSorting fns = new FileNameSorting();
		fns.solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"});
	}

}
