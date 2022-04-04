package ps.programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

// Summer/Winter Coding(~2018) - 방문 길이
// 2022/04/04 15:05 ~ 15:41 = 36분, 흠... 빡구현 시뮬이니까 다시해보자!
public class VisitLength {
	Coordinate[] d = {new Coordinate(0,1), new Coordinate(0,-1), new Coordinate(-1,0), new Coordinate(1,0)};
	HashMap<Coordinate, Set<Coordinate>> coordinateListHashMap = new HashMap<>();
	int[][] map = new int[11][11];
	Coordinate now = new Coordinate(5,5);
	public int solution(String dirs) {
		int answer = 0;
		String[] split = dirs.split("");
		for (String s : split) {
			Coordinate prev = Coordinate.create(now);
			move(s);
			if(now.correction()) {
				Coordinate staticNow = Coordinate.create(now);
				Set<Coordinate> nowSet1 = coordinateListHashMap.getOrDefault(staticNow, new HashSet<>());
				Set<Coordinate> nowSet2 = coordinateListHashMap.getOrDefault(prev, new HashSet<>());
				if (!nowSet1.contains(prev) && !nowSet2.contains(staticNow)) {
					nowSet1.add(prev);
					nowSet2.add(staticNow);
					answer++;
					coordinateListHashMap.put(staticNow, nowSet1);
					coordinateListHashMap.put(prev, nowSet2);
				}
			}
		}
		return answer;
	}

	private void move(String s) {
		if(s.equals("U")) {
			now.move(d[0]);
		} else if(s.equals("D")) {
			now.move(d[1]);
		} else if(s.equals("L")) {
			now.move(d[2]);
		} else if(s.equals("R")) {
			now.move(d[3]);
		}
	}

	public static class Coordinate {
		int x, y;
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public static Coordinate create(Coordinate c) {
			return new Coordinate(c.x,c.y);
		}
		public void move(Coordinate coordinate) {
			this.x += coordinate.x;
			this.y += coordinate.y;
		}
		public boolean correction() {
			int tx = x, ty = y;
			x = Math.min(x, 10);
			x = Math.max(x, 0);
			y = Math.min(y, 10);
			y = Math.max(y, 0);
			return tx==x && ty==y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Coordinate that = (Coordinate)o;
			return x == that.x && y == that.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}
}
