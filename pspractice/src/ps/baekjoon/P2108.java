package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

// 2022/06/26 15:51 ~ 16:11 = 20분
public class P2108 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static Map<Integer, Integer> map = new HashMap<>();
	static List<Integer> list = new ArrayList<>();
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static double sum;

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int v = Integer.parseInt(br.readLine());
			list.add(v);
			map.put(v,map.getOrDefault(v,0)+1);
			sum+=v;
			max = Math.max(max,v);
			min = Math.min(min,v);
		}
		List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
		entries.sort((o1, o2) -> {
			int comp = Integer.compare(o2.getValue(), o1.getValue());
			return comp == 0 ? Integer.compare(o1.getKey(), o2.getKey()) : comp;
		});
		Collections.sort(list);
		System.out.println(Math.round(sum/list.size()));
		System.out.println(list.get(list.size()/2));
		if(n!=1) {
			boolean notOne = entries.get(0).getValue().equals(entries.get(1).getValue());
			System.out.println(notOne ? entries.get(1).getKey() : entries.get(0).getKey());
		} else {
			System.out.println(entries.get(0).getKey());
		}
		System.out.println(max-min);
	}
}
