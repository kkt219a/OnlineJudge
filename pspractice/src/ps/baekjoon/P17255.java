package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 2022/06/25 16:53 ~ 17:39 = 46분
public class P17255 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] arr;
	static boolean[] visited;
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		char[] arr2 = br.readLine().toCharArray();
		arr = new int[arr2.length];
		for(int i=0;i<arr2.length;i++) {
			arr[i] = arr2[i]-'0';
		}
		visited = new boolean[arr.length];
		for (int i = 0; i < arr.length; i++) {
			dfs(i, i, arr[i]+"", arr[i]+"");
		}
		System.out.println(set.size());
	}

	private static void dfs(int startIdx, int endIdx, String last, String all) {
		if (startIdx==0 && endIdx == arr.length-1) {
			set.add(all);
		} else {
			if (startIdx != 0) {
				dfs(startIdx - 1, endIdx, arr[startIdx-1]+last , all + " "+arr[startIdx - 1]+ last);
			}
			if (endIdx != arr.length - 1) {
				dfs(startIdx, endIdx + 1, last+arr[endIdx+1], all+" "+last + arr[endIdx+1]);
			}
		}
	}
}
