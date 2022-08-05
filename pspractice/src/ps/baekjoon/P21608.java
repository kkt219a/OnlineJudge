package ps.baekjoon;

import java.util.PriorityQueue;
import java.util.Queue;

// 2022/08/04 10:19 ~ 10:38 / 16:28 ~ 16:55 = 46분
public class P21608 {
	static int n, sum;
	static int[][] studentNums;
	static int[][] students;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

	public static void main(String[] args) throws Exception {
		n = read();
		students = new int[n * n + 1][4];
		studentNums = new int[n + 1][n + 1];
		for (int i = 0, j = n * n; i < j; i++) {
			int number = read();
			for (int k = 0; k < 4; k++) {
				students[number][k] = read();
			}
			Queue<Student> queue = new PriorityQueue<>();
			for (int a = 1; a <= n; a++) {
				for (int b = 1; b <= n; b++) {
					if (studentNums[a][b] == 0) {
						queue.add(getStudent(a, b, number));
					}
				}
			}
			Student first = queue.poll();
			Queue<Student> temp = new PriorityQueue<>();
			while (!queue.isEmpty() && queue.peek().likeNum == first.likeNum) {
				temp.offer(queue.poll());
			}
			if (temp.isEmpty()) {
				studentNums[first.row][first.column] = first.number;
				continue;
			}
			temp.add(first);
			Queue<Student> temp2 = new PriorityQueue<>();
			Student second = temp.poll();
			while (!temp.isEmpty() && temp.peek().emptyNum == second.emptyNum) {
				temp2.offer(temp.poll());
			}
			if (temp2.isEmpty()) {
				studentNums[second.row][second.column] = second.number;
				continue;
			}
			temp2.add(second);
			Student third = temp2.peek();
			studentNums[third.row][third.column] = third.number;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int num = studentNums[i][j];
				int cnt = 0;
				for (int k = 0; k < 4; k++) {
					int x = i + dx[k], y = j + dy[k];
					if (x > 0 && y > 0 && x <= n && y <= n) {
						for (int l = 0; l < 4; l++) {
							if (studentNums[x][y] == students[num][l]) {
								cnt++;
								break;
							}
						}
					}
				}
				sum += (cnt < 2 ? cnt : (cnt == 2 ? 10 : (cnt == 3 ? 100 : 1000)));
			}
		}
		System.out.println(sum);

	}

	private static Student getStudent(int a, int b, int num) {
		Student student = new Student(a, b, num);
		for (int i = 0; i < 4; i++) {
			int newX = a + dx[i], newY = b + dy[i];
			if (newX > 0 && newY > 0 && newX <= n && newY <= n) {
				if (studentNums[newX][newY] == 0) {
					student.empty();
				} else {
					for (int j = 0; j < 4; j++) {
						if (students[num][j] == studentNums[newX][newY]) {
							student.like();
						}
					}
				}
			}
		}
		return student;
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		return n;
	}

	static class Student implements Comparable<Student> {
		int likeNum = 0, emptyNum = 0, row, column, number;

		public Student(int row, int column, int number) {
			this.row = row;
			this.column = column;
			this.number = number;
		}

		void like() {
			this.likeNum++;
		}

		void empty() {
			this.emptyNum++;
		}

		@Override
		public int compareTo(Student o) {
			int comp1 = Integer.compare(o.likeNum, this.likeNum);
			if (comp1 != 0) {
				return comp1;
			}
			int comp2 = Integer.compare(o.emptyNum, this.emptyNum);
			if (comp2 != 0) {
				return comp2;
			}
			int comp3 = Integer.compare(this.row, o.row);
			if (comp3 != 0) {
				return comp3;
			}
			return Integer.compare(this.column, o.column);
		}
	}
}
