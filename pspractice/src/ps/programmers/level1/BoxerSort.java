package ps.programmers.level1;

//19분
import java.util.*;
public class BoxerSort {
    static List<Person> obj = new ArrayList<>();
    public static int[] solution(int[] weights, String[] head2head) {
        int[] answer = {};
        for(int i=0;i<head2head.length;i++){
            int tot=0,win=0,more=0;
            for(int j=0;j<head2head[i].length();j++){
                if(head2head[i].charAt(j)!='N') tot++;
                if(head2head[i].charAt(j)=='W'){
                    win++;
                    if(weights[i]<weights[j]){
                        more++;
                    }
                }
            }
            double per = (tot==0) ? 0 : ((double)win/tot)*100;
            obj.add(new Person(i+1,more,weights[i],per));
        }
        obj.sort((o1,o2)->{
            int p = Double.compare(o2.percent,o1.percent);
            if(p==0){
                int m = Integer.compare(o2.more,o1.more);
                if(m!=0) return m;
                else{
                    int w = Integer.compare(o2.weight,o1.weight);
                    return w!=0 ? w : Integer.compare(o1.num,o2.num);
                }
            }else{
                return p;
            }
        });
        answer = obj.stream().mapToInt(o->o.num).toArray();
        return answer;
    }
    static class Person{
        int num, weight,more; double percent;
        public Person(int num, int more, int weight, double percent){
            this.num = num; this.more = more; this.weight = weight; this.percent = percent;
        }
    }
}