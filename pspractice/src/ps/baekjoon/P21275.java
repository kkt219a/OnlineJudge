package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

// 2022/06/15 11:13 ~ 12:13 = 60분
public class P21275 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static Map<Long, List<Integer>> aMap = new HashMap<>();
	static Map<Long, List<Integer>> bMap = new HashMap<>();


	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		char[] a = st.nextToken().toCharArray();
		char[] b = st.nextToken().toCharArray();
		calcMap(a, minBinary(a), aMap);
		calcMap(b, minBinary(b), bMap);
		int cnt = 0;
		for (Map.Entry<Long, List<Integer>> aEntry : aMap.entrySet()) {
			Long key = aEntry.getKey();
			List<Integer> aLists = aEntry.getValue();
			List<Integer> bLists = bMap.getOrDefault(key, new ArrayList<>());
			for (Integer bV : bLists) {
				for (Integer aV : aLists) {
					if(!Objects.equals(aV, bV)) {
						cnt++;
						sb.append(key).append(" ").append(aV).append(" ").append(bV);
					}
				}
			}
			if(cnt>1) {
				break;
			}
		}
		System.out.println(cnt==1 ? sb : cnt>1 ? "Multiple" : "Impossible");

	}

	private static void calcMap(char[] a, int ii, Map<Long, List<Integer>> aMap) {
		for(int i=ii;i<=36;i++) {
			long value = convert(a, BigInteger.valueOf(i));
			if(value != -1) {
				List<Integer> list = aMap.getOrDefault(value, new ArrayList<>());
				list.add(i);
				aMap.put(value, list);
			}
		}
	}

	private static int minBinary(char[] a) {
		int maximum = -1;
		for (char c : a) {
			maximum = Math.max(maximum, c);
		}
		return (maximum<58 ? maximum-48 : maximum-87)+1;
	}

	private static long convert(char[] a, BigInteger binary) {
		BigInteger value = BigInteger.ONE;
		BigInteger ret = BigInteger.ZERO;
		for(int i=a.length-1; i>=0; i--) {
			int v2 = a[i] < 58 ? a[i]-48 : a[i]-87;
			ret  = ret.add(value.multiply(BigInteger.valueOf(v2)));
			value = value.multiply(binary);
		}
		try {
			return ret.longValueExact();
		} catch(ArithmeticException e) {
			return -1;
		}
	}
}
