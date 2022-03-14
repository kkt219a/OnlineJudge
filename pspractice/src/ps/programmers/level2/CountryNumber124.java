package ps.programmers.level2;

// 연습문제 - 124 나라의 숫자
// 2022/03/14 아주 어렵게 풀었었고, 오래걸렸다. 쉽게 다시
public class CountryNumber124 {
	String[] arr1 = {"1","2","4"};
	public String solution1(int n) {
		StringBuilder sb = new StringBuilder();
		int v=0,i=1;
		for(;v<n;v+=Math.pow(3,i++));
		i--;
		while(i!=0) {
			int a = (int)(v-Math.pow(3,i)+1);
			int v2 = (int)((n - a) / Math.pow(3, i - 1));
			sb.append(arr1[v2]);
			n-=(Math.pow(3,i-1)*(v2+1));
			v-=Math.pow(3,i);
			i--;
		}
		return sb.toString();
	}

	String[] arr = {"4","1","2"};
	public String solution(int n) {
		StringBuilder sb = new StringBuilder();
		while(n>0) {
			sb.append(arr[n%3]);
			n=(n-1)/3;
		}
		return sb.reverse().toString();
	}
}
