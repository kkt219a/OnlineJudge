package ps.programmers.level1;
import java.util.*;
//23:25~23:58 = 33
class JobRecommend {
    static List<TotalScore> ret = new ArrayList<>();
    public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        for(int i=0;i<table.length;i++){
            String[] split = table[i].split(" ");
            int sum = 0;
            for(int j=0;j<languages.length;j++){
                String lang = languages[j];
                int pref = preference[j];
                int score = 0;
                for(int k=0;k<split.length;k++){
                    if(lang.equals(split[k])){
                        score = split.length-k;
                    }
                }
                sum += score*pref;
            }
            ret.add(new TotalScore(split[0],sum));
        }
        ret.sort((o1, o2) -> {
            int a = Integer.compare(o2.total, o1.total);
            return a != 0 ? a : (o1.name.compareTo(o2.name));
        });
        return ret.get(0).name;
    }
    static class TotalScore {
        String name; int total;
        public TotalScore(String name, int total){ this.name = name; this.total = total; }
    }
}