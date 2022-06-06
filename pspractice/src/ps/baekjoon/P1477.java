package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 2022/06/06 10:23 ~ 10:57, 12:17~ =12:47 해설참조
public class P1477 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static List<Integer> list = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		if(n!=0) {
			String[] ns = br.readLine().split(" ");
			for (String s : ns) {
				list.add(Integer.parseInt(s));
			}
		}
		list.add(l);
		list.add(0);
		Collections.sort(list);
		int left = 1, right = l-1;
		while (left <= right) {
			int mid = (left + right) / 2, cnt = 0;
			for (int i = 1; i < list.size(); i++) {
				cnt += (list.get(i) - list.get(i - 1) - 1) / mid;
			}
			if (cnt <= m) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(left);
	}
}
