package ps.programmers.level2.menu_renewal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 2021 KAKAO BLIND RECRUITMENT - 메뉴 리뉴얼
// 2022/04/18 17:57~18:48 = 51분, 리팩토링
public class MenuRenewalV3 {
    Map<String, Integer> menus = new HashMap<>();
    List<Integer> courseList = new ArrayList<>();
    int maxCombination;
    int[] maxNum = new int[10];

    public String[] solution(String[] orders, int[] course) {
        courseList = Arrays.stream(course).boxed().collect(Collectors.toList());
        maxCombination = courseList.get(courseList.size()-1);
        for (String order : orders) {
            char[] chars = order.toCharArray();
            Arrays.sort(chars);
            dfs(0,-1,  String.valueOf(chars), "");
        }
        menus.entrySet().removeIf(e -> e.getValue() < 2 || e.getValue() < maxNum[e.getKey().length()]);
        return menus.keySet()
            .stream()
            .sorted(String::compareTo)
            .toArray(String[]::new);
    }

    public void dfs(int depth, int lastIdx, String order, String orderCombination) {
        if(courseList.contains(depth)) {
            int val = menus.getOrDefault(orderCombination, 0) + 1;
            menus.put(orderCombination, val);
            maxNum[orderCombination.length()-1] = Math.max(maxNum[orderCombination.length()-1], val);
        }
        if(depth < maxCombination) {
            for(int i=lastIdx+1; i<order.length(); i++) {
                dfs(depth+1, i, order, orderCombination+order.charAt(i));
            }
        }
    }

}
