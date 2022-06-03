package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

// 2022/06/03 16:48 ~ 16:57 = 9분
public class P5883 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static List<Integer> arrList = new ArrayList<>();
	static Set<Integer> arrSet = new HashSet<>();
	static int ret = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int v = Integer.parseInt(br.readLine());
			arrList.add(v);
			arrSet.add(v);
		}
		for (Integer setInteger : arrSet) {
			int continuous = 1;
			int prevValue = -1;
			for (Integer listInteger : arrList) {
				if(listInteger.equals(setInteger)) {
					continue;
				}
				continuous = (prevValue == listInteger) ? continuous+1 : 1;
				prevValue = listInteger;
				ret = Math.max(continuous, ret);
			}
		}
		System.out.println(ret);
	}
}
