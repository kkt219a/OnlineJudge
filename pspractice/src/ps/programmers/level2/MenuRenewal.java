package ps.programmers.level2;

import java.util.*;

//2021 KAKAO BLIND RECRUITMENT - 메뉴 리뉴얼
// 01 36 ~ 2 10 - 해설참고함 (조합)
public class MenuRenewal {
    static List<String> combination = new ArrayList<>();
    public static String[] solution(String[] orders, int[] course) {
        Map<String,Integer> menus = new HashMap<>();
        String[] answer = {};
        int[] maxValue = new int[10];
        for (String order : orders) {
            String[] orderArray= order.split("");
            Arrays.sort(orderArray);
            for (int i : course) {
                dfs(orderArray,0,i,"");
            }
        }
        for (String s : combination) {
            Integer defaulted = menus.getOrDefault(s, 0)+1;
            menus.put(s, defaulted);
            maxValue[s.length()-1] = Math.max(maxValue[s.length()-1], defaulted);
        }
        List<String> keySet = new ArrayList<>(menus.keySet());
        List<String> returnValue = new ArrayList<>();
        for(int i=0;i< course.length;i++){
            for (String s : keySet) {
                Integer value = menus.get(s);
                if(value>1&&s.length() == course[i]&&value==maxValue[course[i]-1]){
                    returnValue.add(s);
                }
            }
        }
        Collections.sort(returnValue);
        return returnValue.toArray(answer);
    }

    private static void dfs(String[] original, int idx, int maxLen, String value){
        if(maxLen== value.length()){
            combination.add(value);
        }
        for (int i = idx; i < original.length; i++) {
            dfs(original, i+1, maxLen, value + original[i]);
        }
    }

    public static void main(String[] args) {
        String[] solution = solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4});
        for (String s : solution) {
            System.out.println("s = " + s);
        }
    }

}
