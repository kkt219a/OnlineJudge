package ps.baekjoon;

public class P10162 {
	public static void main(String[] args) throws Exception {
		int a=0,b=0;
		for(int i=0;i<4;a+=read(), i++);
		for(int i=0;i<4;b+=read(), i++);
		System.out.println(Math.max(a,b));
	}
	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}
}
