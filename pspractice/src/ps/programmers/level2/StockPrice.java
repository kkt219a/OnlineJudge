package ps.programmers.level2;
import java.util.*;

//스택/큐 - 주식가격
//12분
public class StockPrice {
    Queue<Integer> a = new LinkedList<>();
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int i=0;
        for (int price : prices) {
            a.add(price);
        }
        while(!a.isEmpty()){
            Integer peek = a.poll();
            int count = 0;
            for (Integer integer : a) {
                count++;
                if(integer<peek){
                    break;
                }
            }
            answer[i++] = count;
        }
        return answer;
    }
}
