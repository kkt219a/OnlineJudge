package ps.programmers.level2.menu_renewal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//2021 KAKAO BLIND RECRUITMENT - 메뉴 리뉴얼
// 2022/04/18 17:57~18:48 = 51분
public class MenuRenewalV2 {
    Map<String, Integer> menus = new HashMap<>();
    List<Integer> courseList = new ArrayList<>();
    int maxCombination;

    public String[] solution(String[] orders, int[] course) {
        courseList = Arrays.stream(course).boxed().collect(Collectors.toList());
        maxCombination = courseList.get(courseList.size()-1);
        for (String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            dfs(0,-1,  String.valueOf(chars), "");
        }
        for (Integer cs : courseList) {
            List<Map.Entry<String, Integer>> list = menus.entrySet()
                .stream()
                .filter(e -> e.getKey().length() == cs)
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
            if(list.size() != 0) {
                Integer maxValue = list.get(list.size() - 1).getValue();
                menus.entrySet()
                    .removeIf(e -> e.getKey().length() == cs && (e.getValue() < maxValue || e.getValue() < 2));
            }
        }
        return menus.keySet()
            .stream().sorted(String::compareTo)
            .toArray(String[]::new);
    }

    public void dfs(int depth, int lastIdx, String order, String orderCombination) {
        if(courseList.contains(depth)) {
            menus.put(orderCombination, menus.getOrDefault(orderCombination, 0)+1);
        }
        if(depth < maxCombination) {
            for(int i=lastIdx+1; i<order.length(); i++) {
                dfs(depth+1, i, order, orderCombination+order.charAt(i));
            }
        }
    }

}
