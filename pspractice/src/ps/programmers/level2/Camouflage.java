package ps.programmers.level2;

import java.util.*;

//해시 - 위장 : 수학문젠데 이거 ㅠ ...
//1시간반, 검색
public class Camouflage {
    HashMap<String, Integer> comb = new HashMap<>();
    public int solution(String[][] clothes) {
        int total = 1;
        for (String[] clothe : clothes) {
            comb.put(clothe[1],comb.getOrDefault(clothe[1],0)+1);
        }
        for (String s : comb.keySet()) {
            total *= comb.get(s)+1;
        }
        return total;
    }
}
