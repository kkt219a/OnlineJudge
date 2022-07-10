package ps.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 2022/0x/xx xx:xx ~ xx:xx = xx분
public class P10825 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static List<Person> ps = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		int n = parseIntBr();
		for(int i=0;i<n;i++) {
			newToken();
			ps.add(new Person(st.nextToken(), parseIntSt(), parseIntSt(), parseIntSt()));
		}
		Collections.sort(ps);
		for (Person p : ps) {
			sb.append(p.name).append("\n");
		}
		System.out.println(sb);
	}

	static int parseIntSt() {
		return Integer.parseInt(st.nextToken());
	}

	static int parseIntBr() throws IOException {
		return Integer.parseInt(br.readLine());
	}

	static void newToken() throws IOException {
		st = new StringTokenizer(br.readLine());
	}

	static class Person implements Comparable<Person> {
		String name;
		int k, e, m;
		public Person(String name, int k, int e, int m) {
			this.name = name;
			this.k = k;
			this.e = e;
			this.m = m;
		}

		@Override
		public int compareTo(Person o) {
			int ko = Integer.compare(o.k, this.k);
			if(ko!=0) {
				return ko;
			}
			int en = Integer.compare(this.e, o.e);
			if(en != 0) {
				return en;
			}
			int ma = Integer.compare(o.m, this.m);
			if(ma != 0) {
				return ma;
			}
			return this.name.compareTo(o.name);
		}
	}
}
