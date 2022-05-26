package ps.baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 2022/05/27 02:20 ~ 02:55 = 35분
public class P2852 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] scores = new int[2];
	static int[] nowTimes = new int[2];
	static int[] sumTimes = new int[2];

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String[] infos = br.readLine().split(" ");
			int teamNumber = Integer.parseInt(infos[0]);
			int opponentTeamNumber = teamNumber == 1 ? 2 : 1;
			int nowTime = toSecond(infos[1]);
			scores[teamNumber-1]++;
			// 동점이 되면 상대팀의 시간을 계산해 sum을 해준다.
			if(scores[teamNumber-1] == scores[opponentTeamNumber-1]) {
				sumTimes[opponentTeamNumber-1] += (nowTime - nowTimes[opponentTeamNumber-1]);
				nowTimes[teamNumber-1] = nowTime;
			}
			// 넣는 순간 이기면 현재 시간을 기록한다.
			else if(scores[teamNumber-1] - scores[opponentTeamNumber-1] == 1) {
				nowTimes[teamNumber-1] = nowTime;
			}
		}
		if(scores[0]<scores[1]) {
			sumTimes[1] += (2880-nowTimes[1]);
		} else if(scores[0]>scores[1]) {
			sumTimes[0] += (2880-nowTimes[0]);
		}
		System.out.println(toMinuteSecond(sumTimes[0]));
		System.out.println(toMinuteSecond(sumTimes[1]));
	}

	private static int toSecond(String minuteSecondTime) {
		String[] time = minuteSecondTime.split(":");
		return Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
	}
	private static String toMinuteSecond(int secondTime) {
		int minute = secondTime / 60;
		int second = secondTime % 60;
		return (minute < 10 ? "0"+minute : minute) + ":" + (second < 10 ? "0"+second : second);
	}
}
