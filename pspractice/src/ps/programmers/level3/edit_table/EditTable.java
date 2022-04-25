package ps.programmers.level3.edit_table;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// 2021 카카오 채용연계형 인턴십 - 표 편집
// 2022/04/24 13:27~14:04 = 37분(정확성-30점)
public class EditTable {
	Stack<TableInfo> deleteRow = new Stack<>();
	List<Integer> tables = new LinkedList<>();
	int nowIdx;
	public String solution(int n, int k, String[] cmd) {
		nowIdx = k;
		for(int i=0;i<n;i++) { // 100만
			tables.add(i);
		}
		for (String s : cmd) { // 20만
			if(s.contains("C")) {
				deleteRow.push(new TableInfo(nowIdx, tables.get(nowIdx)));
				tables.remove(nowIdx); // 수행시간 100만
				// 삭제된 인덱스가 마지막 행이었다면 한칸 뒤로 빼주기
				if(nowIdx > tables.size()-1) {
					nowIdx--;
				}
			} else if(s.contains("Z")) {
				TableInfo pop = deleteRow.pop();
				nowIdx += pop.idx <= nowIdx ? 1 : 0;
				tables.add(pop.idx, pop.element); // 수행시간 100만
			} else {
				String[] ss = s.split(" ");
				if(ss[0].equals("U")) {
					nowIdx -= Integer.parseInt(ss[1]);
				} else {
					nowIdx += Integer.parseInt(ss[1]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			if(tables.contains(i)) {
				sb.append("O");
			} else {
				sb.append("X");
			}
		}
		return sb.toString();
	}

	class TableInfo {
		int idx;
		int element;
		public TableInfo(int idx, int element) {
			this.idx = idx;
			this.element = element;
		}
	}

	public static void main(String[] args) {
		EditTable editTable = new EditTable();
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
