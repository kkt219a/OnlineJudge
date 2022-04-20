package ps.programmers.level1.new_id_recommend;

// 2021 KAKAO BLIND RECRUITMENT - 신규 아이디 추천
// 2022/04/20 16:20 ~ 16:40 = 20분
public class NewIdRecommendV2 {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();// 1
        StringBuilder sb = new StringBuilder(); // 2,3
        for(int i=0;i<new_id.length();i++) {
            char c = new_id.charAt(i);
            if((c<=122&&c>=97)||(c>=48&&c<=57)||c=='.'||c=='_'||c=='-'){
                if(sb.length()>0 && sb.charAt(sb.length()-1) == '.'&&c=='.') {
                    continue;
                }
                sb.append(c);
            }
        }
        new_id = sb.toString();
        if(new_id.startsWith(".")) { // 4
            new_id = new_id.substring(1);
        }
        if(new_id.endsWith(".")) { // 4
            new_id = new_id.substring(0,new_id.length()-1);
        }
        if(new_id.isBlank()) { // 5
            new_id = "a";
        }
        if(new_id.length()>=16) { // 6
            new_id = new_id.substring(0,15);
            if(new_id.endsWith(".")) {
                new_id = new_id.substring(0,new_id.length()-1);
            }
        }
        if(new_id.length()<3) { // 7
            new_id+=new_id.substring(new_id.length()-1).repeat(3-new_id.length());
        }
        return new_id;
    }

    public static void main(String[] args) {
        NewIdRecommendV2 newIdRecommendV2 = new NewIdRecommendV2();
        newIdRecommendV2.solution("z-+.^.");
    }
}
