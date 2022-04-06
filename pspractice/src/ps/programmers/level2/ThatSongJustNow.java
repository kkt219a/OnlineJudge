package ps.programmers.level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

// 2018 KAKAO BLIND RECRUITMENT - [3차] 방금그곡
// 2022/04/06 09:46~10:30 = 44분, 오 이 문제 재밌당 맞췄지만 꼼꼼하지 못했으니 다시해보기
public class ThatSongJustNow {
	public String solution(String m, String[] musicinfos) {
		m = converter(m);
		List<MusicInfo> musicInfoList = new ArrayList<>();
		for (int i=0;i< musicinfos.length;i++) {
			String[] split = musicinfos[i].split(",");
			musicInfoList.add(new MusicInfo(split[0], split[1], converter(split[3]), split[2], i));
		}
		String finalM = m;
		Optional<MusicInfo> selectedMusic = musicInfoList.stream()
			.filter(musicInfo -> musicInfo.musicSheet.contains(finalM))
			.min((o1, o2) -> {
				int compare = Integer.compare(o2.time, o1.time);
				if (compare != 0) {
					return compare;
				}
				return Integer.compare(o1.idx, o2.idx);
			});
		if(selectedMusic.isPresent()) {
			return selectedMusic.get().name;
		}
		return "(None)";
	}

	public static class MusicInfo {
		int time;
		String musicSheet;
		String name;
		int idx;

		public MusicInfo(String startTime, String endTime, String musicSheet, String name, int idx) {
			String[] startSplits = startTime.split(":");
			String[] endSplits = endTime.split(":");
			this.time = (Integer.parseInt(endSplits[0])*60 + Integer.parseInt(endSplits[1])) - (Integer.parseInt(startSplits[0])*60 + Integer.parseInt(startSplits[1]));
			this.musicSheet = musicSheet.repeat(time/musicSheet.length()) + musicSheet.substring(0,time%musicSheet.length());
			this.name = name;
			this.idx = idx;
		}
	}

	public String converter(String song) {
		return song.replace("C#","H")
			.replace("D#","I")
			.replace("F#","J")
			.replace("G#","K")
			.replace("A#","L");
	}
}
