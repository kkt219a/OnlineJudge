package ps.baekjoon;

import ps.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//01:10~01:30
public class P1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        List<Conf> lists = new ArrayList<>();
        int cnt = 0,nowTime = 0;
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            String[] s = br.readLine().split(" ");
            lists.add(new Conf(Integer.parseInt(s[0]),Integer.parseInt(s[1])));
        }
        lists.sort(Comparator.comparingInt((Conf o) -> o.end).thenComparingInt(o -> o.start));
        for (Conf list : lists) {
            if(nowTime<=list.start){
                cnt++;
                nowTime = list.end;
            }
        }
        System.out.println(cnt);
    }
    static class Conf{
        int start,end;
        public Conf(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
