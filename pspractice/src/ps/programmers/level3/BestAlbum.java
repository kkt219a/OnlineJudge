package ps.programmers.level3;

import java.util.*;

//해시 - 베스트앨범
// 22:44~23:19 = 35분
public class BestAlbum {
    HashMap<String, Integer> genre = new HashMap<>();
    HashMap<String, List<Song>> song = new HashMap<>();
    List<Integer> answers = new ArrayList<>();
    public int[] solution(String[] genres, int[] plays) {
        for(int i=0,j= genres.length;i<j;i++){
            genre.put(genres[i], genre.getOrDefault(genres[i],0)+plays[i]);
            List<Song> songList = song.getOrDefault(genres[i], new ArrayList<>());
            songList.add(new Song(i,plays[i]));
            song.put(genres[i],songList);
        }
        List<String> keySetList = new ArrayList<>(genre.keySet());
        keySetList.sort((o1, o2) -> (genre.get(o2).compareTo(genre.get(o1))));
        for (String s : keySetList) {
            List<Song> songs = song.get(s);
            Collections.sort(songs);
            answers.add(songs.get(0).idx);
            if(songs.size()!=1) {
                answers.add(songs.get(1).idx);
            }
        }
        return answers.stream().mapToInt(i->i).toArray();
    }

    static class Song implements Comparable<Song> {
        private final int idx;
        private final int playNum;
        public Song(int idx, int playNum) {
            this.idx = idx;
            this.playNum = playNum;
        }
        @Override
        public int compareTo(Song o) {
            int comp = Integer.compare(o.playNum,this.playNum);
            return comp!=0 ? comp : Integer.compare(this.idx,o.idx);
        }
    }
}
