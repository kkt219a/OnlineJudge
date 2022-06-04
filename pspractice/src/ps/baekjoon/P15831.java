package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2022/06/04 17:01 ~ 17:21 = 20분
public class P15831 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Queue<Character> queue = new LinkedList<>();
	static int n, b, w;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		char[] sentences = br.readLine().toCharArray();
		int nowB = 0, nowW = 0;
		int maxLen = 0;
		for (int start = 0, end = 0; end < n; end++) {
			char now = sentences[end];
			queue.offer(now);
			if (now == 'B') {
				nowB++;
				while (!queue.isEmpty() && start <= end && nowB > b) {
					Character poll = queue.poll();
					start++;
					if (poll == 'B') {
						nowB--;
					} else {
						nowW--;
					}
				}

			} else {
				nowW++;
			}
			if (nowW >= w) {
				maxLen = Math.max(queue.size(), maxLen);
			}
		}
		System.out.println(maxLen);
	}
}
