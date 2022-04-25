package ps.programmers.level3.edit_table;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 2021 카카오 채용연계형 인턴십 - 표 편집
// 2022/04/24 13:27~15:38 = 131분(정확성+효율성절반 65점)
public class EditTableV2 {
	Stack<Integer> deleteRow = new Stack<>();
	StringBuilder sb = new StringBuilder();
	int nowIdx;
	public String solution(int n, int k, String[] cmd) {
		nowIdx = k;
		for(int i=0;i<n;i++) { // 100만
			sb.append('O');
		}
		for (String s : cmd) { // 20만
			if(s.equals("C")) { // 삭제
				deleteRow.push(nowIdx);
				sb.setCharAt(nowIdx,'X');
				int i = nowIdx;
				for(;i < sb.length();i++) {
					if (sb.charAt(i) == 'O') {
						break;
					}
				}
				if(i == sb.length()) {
					while(sb.charAt(nowIdx) != 'O') {
						nowIdx--;
					}
				} else {
					nowIdx = i;
				}
			} else if(s.contains("Z")) {
				Integer popIdx = deleteRow.pop();
				sb.setCharAt(popIdx, 'O');
			} else {
				String[] ss = s.split(" ");
				int number = Integer.parseInt(ss[1]);
				if(ss[0].equals("U")) {
					//nowIdx가 -1을 만나는게 아니라면 카운트 업 인정
					for(int i=0;i<number;nowIdx--) {
						if(sb.charAt(nowIdx) == 'O') {
							i++;
						}
					}
					while(sb.charAt(nowIdx) != 'O') {
						nowIdx--;
					}
				} else {
					//nowIdx가 -1을 만나는게 아니라면 카운트 다운 인정
					for(int i=0;i<number;nowIdx++) {
						if(sb.charAt(nowIdx) == 'O') {
							i++;
						}
					}
					while(sb.charAt(nowIdx) != 'O') {
						nowIdx++;
					}
				}
			}
		}
		// System.out.println(sb);
		return sb.toString();
	}

	public static void main(String[] args) {
		EditTableV2 editTable = new EditTableV2();
		editTable.solution(8,2,new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"});
		System.out.println("-------");
		List<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(3);
		a.add(5);
		a.add(7);
		a.add(9);
		System.out.println(a.get(2));
		a.remove(Integer.valueOf(5));
		System.out.println(a.get(2));
		a.add(1,2);
		System.out.println(a);
	}

}
